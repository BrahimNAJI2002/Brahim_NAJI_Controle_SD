package brahim.enset.conferenceservice.restClient;

import brahim.enset.conferenceservice.model.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "keynote-service")
public interface keynoteRestClient {

    @GetMapping("/api/keynotes/{id}")
    Keynote getKeynoteById(@PathVariable("id") Long id);
}