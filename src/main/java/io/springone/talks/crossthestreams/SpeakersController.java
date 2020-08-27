package io.springone.talks.crossthestreams;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@Slf4j
public class SpeakersController {

  @GetMapping("/speakers")
  public Collection<String> speakers(@RequestParam(defaultValue = "1000") Long delay)
      throws InterruptedException {

    log.info("Received /speakers request");
    Thread.sleep(delay);
    log.info("Finished artificial delay");
    return List.of("Juergen Hoeller", "Josh Long", "Madhura Bhave");
  }
}
