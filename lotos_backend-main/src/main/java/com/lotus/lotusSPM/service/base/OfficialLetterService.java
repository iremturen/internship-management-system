package com.lotus.lotusSPM.service.base;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.lotus.lotusSPM.model.Admin;
import com.lotus.lotusSPM.model.ApplicationForm;
import com.lotus.lotusSPM.model.Messages;
import com.lotus.lotusSPM.model.OfficialLetter;

public interface OfficialLetterService {

	OfficialLetter createOfficialLetter(OfficialLetter of) ;
	List<OfficialLetter> getOfficialLetter();
	OfficialLetter findById(Long id);
	OfficialLetter store(MultipartFile file) throws IOException;
	OfficialLetter findByUsername(String username);


}
