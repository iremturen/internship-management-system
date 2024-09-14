package com.lotus.lotusSPM.service.base;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.lotus.lotusSPM.model.Documents;

public interface DocumentsService {

	void deleteDocument(String id);
	List<Documents> getDocuments();
	Documents store(MultipartFile file) throws IOException;
	Documents getFile(String id);
	Stream<Documents> getAllFiles();
}
