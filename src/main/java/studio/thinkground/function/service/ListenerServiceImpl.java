package studio.thinkground.function.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import studio.thinkground.function.entity.listner.ListenerEntity;
import studio.thinkground.function.repository.ListenerRepository;

// 0931
@Service
public class ListenerServiceImpl implements ListenerService {
  private ListenerRepository listenerRepository;

  @Autowired
  public ListenerServiceImpl(ListenerRepository listenerRepository) {
    this.listenerRepository = listenerRepository;
  }

  @Override
  public ListenerEntity getEntity(Long id) {
    return listenerRepository.findById(id).get();
  }

  @Override
  public void saveEntity(ListenerEntity listenerEntity) {
    listenerRepository.save(listenerEntity);
  }

  @Override
  public void updateEntity(ListenerEntity listenerEntity) {
    ListenerEntity foundListener = listenerRepository.findById(listenerEntity.getId()).get();
    foundListener.setName(listenerEntity.getName());
    listenerRepository.save(foundListener);
  }

  @Override
  public void removeEntity(ListenerEntity listenerEntity) {
    listenerRepository.delete(listenerEntity);
  }
}
