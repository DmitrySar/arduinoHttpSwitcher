package diplom.arduinoHttpSwitcher.repository;

import diplom.arduinoHttpSwitcher.entity.Switcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SwitcherRepository extends CrudRepository<Switcher, Integer> {
    List<Switcher> findByTimeBetween(LocalDateTime start, LocalDateTime stop);
    List<Switcher> findByNameAndTimeBetween(String name, LocalDateTime start, LocalDateTime stop);

}
