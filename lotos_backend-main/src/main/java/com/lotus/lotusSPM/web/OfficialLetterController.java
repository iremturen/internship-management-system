package com.lotus.lotusSPM.web;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.lotus.lotusSPM.message.ResponseMessage;
import com.lotus.lotusSPM.model.OfficialLetter;
import com.lotus.lotusSPM.model.Student;
import com.lotus.lotusSPM.service.base.OfficialLetterService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OfficialLetterController {

	@Autowired
	private OfficialLetterService officialLetterService;

	@PostMapping("/officialLetter")
	public ResponseEntity<URI> createOL(@RequestBody OfficialLetter officialLetter) {

		try {
			officialLetterService.createOfficialLetter(officialLetter);
			Long id = officialLetter.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@PostMapping("/uploadLetter")
	  public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("letter") MultipartFile form) {
	    String message = "";
	    try {
	    	officialLetterService.store(form);

	      message = "Uploaded the file successfully: " + form.getOriginalFilename();
	      return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
	    } catch (Exception e) {
	      message = "Could not upload the file: " + form.getOriginalFilename() + "!";
	      return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
	    }
	  }
	
	
	@GetMapping("/officialLetters")
	public ResponseEntity<Object> getLetter() {
		List<OfficialLetter> officialLetter = officialLetterService.getOfficialLetter();
		return ResponseEntity.ok(officialLetter);
	}
	
	@GetMapping("/officialLetter/{username}")
	public ResponseEntity<Object> getLetter(@PathVariable("username") String username) {
		try {
		OfficialLetter ol= officialLetterService.findByUsername(username);
		return ResponseEntity.ok(ol);
		}catch(Exception e){
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
					
		}
		
	}
}
