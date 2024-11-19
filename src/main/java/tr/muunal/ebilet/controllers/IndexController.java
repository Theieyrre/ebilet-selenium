package tr.muunal.ebilet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import tr.muunal.ebilet.EbiletScraper;

@RestController
@RequestMapping("/")
public class IndexController {
    private static final Logger LOGGER = LoggerFactory.getLogger(IndexController.class);

    @GetMapping
    public void index() {
        EbiletScraper ebiletScraper = new EbiletScraper("https://bilet.tcdd.gov.tr/");
    }

    @CrossOrigin
    @GetMapping("/react")
    public String react() {
        LOGGER.info("REACT");
        return "Hello React!";
    }
}
