package diplom.arduinoHttpSwitcher.entity;

public class SwitchUtil {

    private final static int NUMBER_OF_SWITCH = 0;
    private final static int NUMBER_OF_REQUEST = 1;
    private final static int NUMBER_STATUS_REQUEST = 2;
    private final static int SWITCH_ON_REQUEST = 1;
    private String id;

    public SwitchUtil(String id) {
        this.id = id;
    }

    public String nameGenerate() {
        return "SW" + getNumberOfSwitch();
    }

    public char getNumberOfSwitch() {
        return id.charAt(NUMBER_OF_SWITCH);
    }

    public char getRequestNumber() {
        return id.charAt(NUMBER_OF_REQUEST);
    }

    public boolean isStatusRequest() {
        return getRequestNumber() == NUMBER_STATUS_REQUEST;
    }

    public boolean isSwitchOnRequest() {
        return getRequestNumber() == SWITCH_ON_REQUEST;
    }
}
