package studio.thinkground.data.reposittory;

import org.springframework.data.jpa.repository.JpaRepository;
import studio.thinkground.data.Entity.ListenerEntity;

public interface ListenerRepository extends JpaRepository<ListenerEntity, Long> {
/*    public ListenerEntity getEntity(Long id);

    public void saveEntity(ListenerEntity listenerEntity);

    public void updateEntity(ListenerEntity listenerEntity);

    public void removeEntity(ListenerEntity listenerEntity);*/
}
