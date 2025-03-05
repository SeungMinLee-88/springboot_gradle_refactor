package studio.thinkground.service;

import studio.thinkground.data.Entity.ListenerEntity;

public interface ListenerService {
  ListenerEntity getEntity(Long id);

  void saveEntity(ListenerEntity listenerEntity);

  void updateEntity(ListenerEntity listenerEntity);

  void removeEntity(ListenerEntity listenerEntity);
}
