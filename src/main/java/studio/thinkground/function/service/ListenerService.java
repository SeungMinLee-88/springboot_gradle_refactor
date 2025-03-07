package studio.thinkground.function.service;

import studio.thinkground.function.entity.listner.ListenerEntity;

public interface ListenerService {
  ListenerEntity getEntity(Long id);

  void saveEntity(ListenerEntity listenerEntity);

  void updateEntity(ListenerEntity listenerEntity);

  void removeEntity(ListenerEntity listenerEntity);
}
