package diplom.arduinoHttpSwitcher.entity;

import jdk.jfr.Enabled;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class Switcher implements ISwitcher {

    @Id
    @GeneratedValue
    private int id;
    private String name;
    private LocalDateTime time;
    private boolean switchOn;
    private String result;

    public Switcher() {
    }

    public Switcher(String name, boolean switchOn) {
        this.switchOn = switchOn;
        this.time = LocalDateTime.now();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public LocalDateTime getTime() {
        return time;
    }

    @Override
    public boolean isSwitchOn() {
        return switchOn;
    }

    public String getResult() {
        return result;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setSwitchOn(boolean switchOn) {
        this.switchOn = switchOn;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
