package ru.job4j.feign.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.job4j.feign.model.Person;
import ru.job4j.feign.service.FirstFeignService;

@RestController
@RequestMapping("/fx")
public class FeignController {
    private final FirstFeignService firstService;

    public FeignController(FirstFeignService firstService) {
        this.firstService = firstService;
    }

    @PostMapping("/firstperson/{personId}")
    public ResponseEntity<String> createPerson(@PathVariable Long personId, @RequestBody Person person) {
        String line = firstService.firstCreatePerson(personId, person);
        return new ResponseEntity<>(line, HttpStatus.OK);
    }

    @GetMapping("/firstperson/exc")
    public ResponseEntity<String> exc() {
        String line = firstService.getExc();
        return new ResponseEntity<>(line, HttpStatus.OK);
    }

    @GetMapping("/firstperson/head/{header}")
    public ResponseEntity<String> head(@PathVariable String header) {
        String line = firstService.getHead(header);
        return new ResponseEntity<>(line, HttpStatus.OK);
    }
}
