package com.lotus.lotusSPM.service.base;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.lotus.lotusSPM.model.Opportunities;

public interface OpportunitiesService {

	List<Opportunities> getOpportunities();
	Opportunities createOpportunities(Opportunities opportunities);
	Opportunities findById(Long id);
	Opportunities findByUsername(String username);
}
