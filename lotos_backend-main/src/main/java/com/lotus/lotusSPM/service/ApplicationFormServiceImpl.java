package com.lotus.lotusSPM.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.lotus.lotusSPM.dao.ApplicationFormDao;
import com.lotus.lotusSPM.dao.StudentDao;
import com.lotus.lotusSPM.model.ApplicationForm;
import com.lotus.lotusSPM.model.Student;
import com.lotus.lotusSPM.service.base.ApplicationFormService;

@Service
@Transactional(rollbackFor = Exception.class)
public class ApplicationFormServiceImpl implements ApplicationFormService{

	@Autowired
	private  ApplicationFormDao applicationFormDao;
	
	@Autowired
	private StudentDao studentDao;
	
	@Override
	public void deleteForm(String id) {
		applicationFormDao.deleteById(id);		
	}

	@Override
	public List<ApplicationForm> getForms() {
		return applicationFormDao.findAll();
	}

	@Override
	public ApplicationForm store(MultipartFile file,Student student) throws IOException {
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		ApplicationForm FileDB = new ApplicationForm(fileName, file.getContentType(), file.getBytes());
		FileDB.setStu_id(student.getUsername());
		return applicationFormDao.save(FileDB);
	}

	@Override
	public ApplicationForm getForm(String id) {
		Optional<ApplicationForm> form = applicationFormDao.findById(id);
		return form.get();	}

	@Override
	public Stream<ApplicationForm> getAllForms() {
		return applicationFormDao.findAll().stream();
	}

}
