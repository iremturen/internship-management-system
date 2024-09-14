package com.lotus.lotusSPM.service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lotus.lotusSPM.dao.OfficialLetterDao;
import com.lotus.lotusSPM.dao.StudentDao;
import com.lotus.lotusSPM.model.ApplicationForm;
import com.lotus.lotusSPM.model.OfficialLetter;
import com.lotus.lotusSPM.model.Student;
import com.lotus.lotusSPM.service.base.OfficialLetterService;

@Service
@Transactional(rollbackFor = Exception.class)
public class OfficialLetterServiceImpl implements OfficialLetterService {

	@Autowired
	private OfficialLetterDao officialLetterDao;
	@Autowired
	private StudentDao studentDao;

	@Override
	public OfficialLetter createOfficialLetter(OfficialLetter ol) {

		OfficialLetter officialLetter = new OfficialLetter();
		Student student = studentDao.findByUsername(ol.getUsername());

		Document document = new Document();
		try {
			OutputStream outputStream = new FileOutputStream(new File("D:\\OfficialLetter.pdf"));

			PdfWriter.getInstance(document, outputStream);

			document.open();

			document.add(new Paragraph(
					"                                                                                                                 "
							+ ol.getDate()));
			document.add(new Paragraph("      "));
			document.add(new Paragraph("To " + ol.getComName()));
			document.add(new Paragraph("      "));
			document.add(new Paragraph(student.getName() + "  " + student.getSurname()
					+ " who has applied to your department for a summer internship, is studying at Üsküdar University, Faculty of Engineering and Natural Sciences, Software Engineering Department. In the Software Engineering department, there are two compulsory internships, one at the end of the second year and the other at the end of third year. The duration of each compulsory internship is 20 working days. Work Accident and Occupational Diseases Insurance Premiums between the dates of internship of the student are covered by our University. The named student has  "
					+ student.getInternshipStatus()
					+ " compulsory internships. This document has been prepared to inform your institution.  "));
			document.add(new Paragraph("      "));
			document.add(new Paragraph(
					"                                                       Software Engineering Internship Committee Member "));
			document.add(new Paragraph(
					"                                                      Dr. John Smith (name of the department internship coordinator) "));
//******************* coordinator nerede tutulsun tablolar bağlanmalı düzenlenmeli
			document.close();
			outputStream.close();

			System.out.println("Pdf created successfully.");
		} catch (Exception e) {
			e.printStackTrace();
		}

		officialLetter.setId(ol.getId());
		officialLetter.setPdf(documentToByte(document));
		officialLetter.setComName(ol.getComName());
		officialLetter.setDate(ol.getDate());
		return officialLetterDao.save(ol);
	}

	@Override
	public OfficialLetter store(MultipartFile file) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		OfficialLetter FileDB = new OfficialLetter(file.getBytes(),fileName, file.getContentType());
		return officialLetterDao.save(FileDB);
	}

	@Override
	public List<OfficialLetter> getOfficialLetter() {
		return officialLetterDao.findAll();
	}

	
	

	public byte[] documentToByte(Document doc) {
		try {
			ByteArrayOutputStream bos = new ByteArrayOutputStream();
			ObjectOutputStream oos = new ObjectOutputStream(bos);
			oos.writeObject(doc);
			return bos.toByteArray();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
		
	}

	@Override
	public OfficialLetter findById(Long id) {
		return officialLetterDao.findById(id).get();
	}

	@Override
	public OfficialLetter findByUsername(String username) {
		return officialLetterDao.findByUsername(username);
	}

	

}
