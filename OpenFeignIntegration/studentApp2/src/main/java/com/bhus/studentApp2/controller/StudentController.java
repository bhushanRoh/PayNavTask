package com.bhus.studentApp2.controller;

import com.bhus.studentApp2.document.PayuEntity;
import com.bhus.studentApp2.document.Student;
import com.bhus.studentApp2.models.StudentRequest;
import com.bhus.studentApp2.service.StudentService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.codec.ClientCodecConfigurer;
import org.springframework.http.codec.json.Jackson2JsonDecoder;
import org.springframework.http.codec.json.Jackson2JsonEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.ExchangeStrategies;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@RequestMapping("/v1")
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @Autowired
    private WebClient.Builder webclient;


    @GetMapping("student2/{id}")
    public Student getStudent(@PathVariable("id") String id){
        return studentService.getstudent(id);
    }

    @PostMapping(path = "/student2",consumes = MediaType.APPLICATION_JSON_VALUE,produces =MediaType.APPLICATION_JSON_VALUE)


    public Mono<PayuEntity> createStudent(PayuEntity payuEntity){
             return webclient.build().post()
                    .uri("https://info.payu.in/merchant/postservice.php?form=2")
                    .body(Mono.just(payuEntity), PayuEntity.class)
                    .retrieve()
                    .bodyToMono(PayuEntity.class);
    }

    public void acceptedCodecs(ClientCodecConfigurer clientCodecConfigurer) {
//clientCodecConfigurer.defaultCodecs().maxInMemorySize(BUFFER_SIZE_16MB);
        clientCodecConfigurer.customCodecs()
                .registerWithDefaultConfig(new Jackson2JsonDecoder(new ObjectMapper(), MediaType.TEXT_HTML));
        clientCodecConfigurer.customCodecs().registerWithDefaultConfig(new Jackson2JsonEncoder(new ObjectMapper(), MediaType.TEXT_HTML));
    }

    @Bean
    public WebClient webClient(){
        return WebClient.builder()
                .exchangeStrategies(ExchangeStrategies.builder().codecs(this::acceptedCodecs).build())
                .build();
    }

   /* @PutMapping("/student2/{id}")
    public Student updateStudent(@PathVariable String id, @RequestBody StudentRequest request){
        return studentService.updateStudent(id,request);
    }*/

    @DeleteMapping(path = "/student2/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public Student deleteStudentById(@PathVariable final String id){
        studentService.deleteById(id);
        return null;
    }

    public Mono<Student> create(Student student)
    {
        return webclient.build().post()
                .uri("https://info.payu.in/merchant/postservice.php?form=2")
                .body(Mono.just(student), Student.class)
                .retrieve()
                .bodyToMono(Student.class);
    }





}
