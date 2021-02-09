package diplom.arduinoHttpSwitcher.entity;

import java.time.LocalDateTime;

public interface ISwitcher {
    boolean isSwitchOn();
    LocalDateTime getTime();
}
