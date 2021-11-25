package com.bhus.student.service;

import com.bhus.student.model.StudentRequest;
import com.bhus.student.model.StudentResponse;
import feign.Headers;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@Headers("Content-Type: application/json")
@FeignClient(name = "${feign.name}", url = "${feign.url}")
public interface RestClientService {
    @PostMapping("/v1/student2")
    StudentResponse saveStudent(@RequestBody StudentRequest studentRequest);
    @PutMapping("/v1/student2/{studentId}")
    StudentResponse updateStudent(String studentId, StudentRequest request);
    @DeleteMapping(path = "/v1/student2/{studentId}",produces = MediaType.APPLICATION_JSON_VALUE)
    void deleteById(String studentId);
}
