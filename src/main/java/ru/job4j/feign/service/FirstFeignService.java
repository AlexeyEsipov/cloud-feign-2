package ru.job4j.feign.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.job4j.feign.model.Person;

@Service
public class FirstFeignService {
    private final FeignServiceClient client;

    public FirstFeignService(FeignServiceClient client) {
        this.client = client;
    }

    public String firstCreatePerson(Long personId, Person person) {
        ResponseEntity<String> stringResponseEntity = client.firstCreatePerson(personId, person);
        return stringResponseEntity.getBody();
    }
}
