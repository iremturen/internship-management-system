package com.lotus.lotusSPM.service.base;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.lotus.lotusSPM.model.ApplicationForm;
import com.lotus.lotusSPM.model.Student;

public interface ApplicationFormService {

	void deleteForm(String id);
	List<ApplicationForm> getForms();
	ApplicationForm store(MultipartFile file,Student student) throws IOException;
	ApplicationForm getForm(String id);
	Stream<ApplicationForm> getAllForms();
}
