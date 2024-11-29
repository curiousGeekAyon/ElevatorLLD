public abstract class ElevatorControllerState {
    ElevatorController elevatorController;
    public abstract void openDoor();
    public abstract void closeDoor();
    public abstract void move();
}
