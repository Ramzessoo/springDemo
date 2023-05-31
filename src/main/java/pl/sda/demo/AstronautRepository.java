package pl.sda.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AstronautRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(AstronautRepository.class);

    private static int index = 0;

    private Map<Integer, Astronaut> astronautMap = new HashMap<>();

    public Astronaut save(Astronaut astronaut) {

        astronautMap.putIfAbsent(index, astronaut);
        LOGGER.debug("saving astronaut {} under index {}", astronaut, index);
        index++;

        return astronaut;
    }

    public List<Astronaut> getAllAstronauts() {
       return astronautMap.entrySet()
                .stream()
               .map()
               .collect(Collectors.toList());
    }
}
