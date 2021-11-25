package com.bhushan.studentservice.controller;

import com.bhushan.studentservice.model.SchoolRequest;
import com.bhushan.studentservice.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/v1")
@RestController
public class SchoolController {
    @Autowired
    SchoolService schoolService;

    @PostMapping("/school")
    public ResponseEntity<?> createSchool(@RequestBody SchoolRequest schoolRequest){
        return new ResponseEntity<>(schoolService.saveSchool(schoolRequest), HttpStatus.CREATED);
    }

  /*  @PutMapping("/school/{schoolId}")
    public ResponseEntity<?> updateSchool(@PathVariable String schoolId, @RequestBody SchoolRequest request){
        return new ResponseEntity<>(schoolService.updateSchool(schoolId,request),HttpStatus.ACCEPTED);
    }*/

    @GetMapping(path = "/school/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?>getSchoolById(@PathVariable final String id){
        return new ResponseEntity<>(schoolService.getSchoolById(id), HttpStatus.OK);
    }

   /* @DeleteMapping(path = "/school/{schoolId}",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteSchoolById(@PathVariable final String schoolId){
        schoolService.deleteById(schoolId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT.getReasonPhrase(), HttpStatus.NO_CONTENT);
    }*/



}
