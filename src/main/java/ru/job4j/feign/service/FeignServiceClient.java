package ru.job4j.feign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.job4j.feign.model.Person;

@FeignClient(name = "first")
public interface FeignServiceClient {


    @PostMapping("one/person/{personId}")
    ResponseEntity<String> firstCreatePerson(@PathVariable Long personId, @RequestBody Person person);

    @GetMapping("one/person/exc")
    ResponseEntity<String> getExc();

}
