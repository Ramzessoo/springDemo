package pl.sda.demo;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AstroWebService {

    private final RestTemplateBuilder builder;

    private final AstronautRepository repository;

    public AstroWebService(RestTemplateBuilder builder, AstronautRepository repository) {
        this.builder = builder;
        this.repository = repository;
    }
    Astronaut save(Astronaut astronaut) {
       return repository.save(astronaut);

    }
    Map<String, Long> getAstronauts() {
        var url = "http://api.open-notify.org/astros.json";
        return builder
                .build()
                .getForObject(url, AstronautsResult.class)
                .people()
                .stream()
                .collect(Collectors.groupingBy(Astronaut::craft, Collectors.counting()));
    }


}
