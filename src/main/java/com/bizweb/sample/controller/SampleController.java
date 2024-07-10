package com.bizweb.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bizweb.sample.config.ResponseConfig;
import com.bizweb.sample.exception.ResourceNotFoundException;

@RestController
@RequestMapping("/api")
public class SampleController {
	
	@Autowired
    private ResponseConfig responseConfig;

    @GetMapping("/success")
    public ResponseEntity<String> getSuccess() {
        return ResponseEntity.ok(responseConfig.getSuccess());
    }

    @GetMapping("/error")
    public ResponseEntity<String> getError() {
        throw new ResourceNotFoundException("ResourceName", "FieldName", "FieldValue");
    }

}
