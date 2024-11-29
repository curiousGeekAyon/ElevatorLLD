import java.util.Scanner;

public class Door {
    DoorStatus doorStatus;

    public Door(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }

    public DoorStatus getDoorStatus() {
        return doorStatus;
    }


    public void setDoorStatus(DoorStatus doorStatus) {
        this.doorStatus = doorStatus;
    }
}
