package studio.thinkground.function.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import studio.thinkground.function.entity.listner.ListenerEntity;
import studio.thinkground.function.service.ListenerService;

// 0919
@RestController
@RequestMapping("/listener")
public class ListenerController {

  private final Logger LOGGER = LoggerFactory.getLogger(ListenerController.class);

  private ListenerService listenerService;

  @Autowired
  public ListenerController(ListenerService listenerService) {
    this.listenerService = listenerService;
  }

  @GetMapping
  public String getListener(Long id) {
    LOGGER.info("getListener id : " + id);
    listenerService.getEntity(id);

    return "ok";
  }

  @PostMapping
  public void saveListener(String name) {
    LOGGER.info("saveListener name : " + name);
    ListenerEntity listenerEntity = new ListenerEntity();
    listenerEntity.setName(name);

    listenerService.saveEntity(listenerEntity);
  }

  @PutMapping
  public void updateListener(Long id, String name) {
    LOGGER.info("updateListener id : " + id);
    LOGGER.info("updateListener name : " + name);
    ListenerEntity listenerEntity = new ListenerEntity();
    listenerEntity.setId(id);
    listenerEntity.setName(name);

    listenerService.updateEntity(listenerEntity);
  }

  @DeleteMapping
  public void deleteListener(Long id) {
    ListenerEntity listenerEntity = new ListenerEntity();
    listenerEntity.setId(id);
    listenerService.removeEntity(listenerEntity);
  }
}
