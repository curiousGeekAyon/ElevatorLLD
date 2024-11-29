import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ElevatorCar {
    int id;
    Direction direction;
    List<InternalButton> floorButtons;
    DoorButton doorButton;
    Door door;
    int floorNo;

    public ElevatorCar(int id, Direction direction,int floorCount) {
        this.id = id;
        this.direction = direction;
        door=new Door(DoorStatus.CLOSE);
    }

    public int getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(int floorNo) {
        this.floorNo = floorNo;
    }

    public DoorButton getDoorButton() {
        return doorButton;
    }

    public void setDoorButton(DoorButton doorButton) {
        this.doorButton = doorButton;
    }

    public List<InternalButton> getFloorButtons() {
        return floorButtons;
    }

    public void setFloorButtons(List<InternalButton> floorButtons) {
        this.floorButtons = floorButtons;
    }

    public Door getDoor() {
        return door;
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

//    public List<InternalButton> getInternalButtons() {
//        return internalButtons;
//    }

    public void setInternalButtons(List<InternalButton> floorButtons) {
        this.floorButtons = floorButtons;
    }
    public void openDoor()
    {
        door.setDoorStatus(DoorStatus.OPEN);
        getDestination();
    }

    private void getDestination() {
        System.out.print("Please enter your destination: ");
        Scanner sc=new Scanner(System.in);
        int destination=sc.nextInt();
        System.out.println("Destination set to "+destination);

    }

    public void closeDoor()
    {
        door.setDoorStatus(DoorStatus.CLOSE);
    }
}
