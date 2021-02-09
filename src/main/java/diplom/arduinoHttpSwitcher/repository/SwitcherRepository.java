package diplom.arduinoHttpSwitcher.repository;

import diplom.arduinoHttpSwitcher.entity.Switcher;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SwitcherRepository extends CrudRepository<Switcher, Integer> {
}
