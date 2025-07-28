package ru.job4j.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.feign.model.Person;

@FeignClient(name = "first")
public interface FeignServiceClient {


    @PostMapping("one/person/{personId}")
    ResponseEntity<String> firstCreatePerson(@PathVariable Long personId,
                                             @RequestBody Person person);

    @GetMapping("one/person/exc")
    ResponseEntity<String> getExc();

    @GetMapping("one/person/head")
    ResponseEntity<String> head(@RequestHeader(name = "X-Name-Courses")
                                String nameCourses);
}
