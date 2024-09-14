package com.lotus.lotusSPM.web;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lotus.lotusSPM.message.ResponseMessage;
import com.lotus.lotusSPM.model.Opportunities;
import com.lotus.lotusSPM.service.base.OpportunitiesService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class OpportunitiesController {

	@Autowired
	private OpportunitiesService opportunitiesService;

	@PostMapping("/opportunitie")
	public ResponseEntity<URI> createOpportunitie(@RequestBody Opportunities opportunities) {
		try {
			opportunitiesService.createOpportunities(opportunities);
			Long id = opportunities.getId();
			URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
			return ResponseEntity.created(location).build();
		} catch (Exception ex) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	
	

	@GetMapping("/opportunities")
	public ResponseEntity<Object> getOpportunities() {
		List<Opportunities> opportunities = opportunitiesService.getOpportunities();
		return ResponseEntity.ok(opportunities);
	}

	@GetMapping("/opportunities/{id}")
	public ResponseEntity<Object> getOpportunities(@PathVariable("id") Long id) {

		Opportunities opp = opportunitiesService.findById(id);
		return ResponseEntity.ok(opp);

	}
}
