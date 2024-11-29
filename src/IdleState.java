public class IdleState extends ElevatorControllerState{

    public IdleState(ElevatorController elevatorController) {
        this.elevatorController=elevatorController;
    }

    @Override
    public void closeDoor() {
        ElevatorCar elevatorCar=elevatorController.getElevatorCar();
        if(elevatorCar.getDoor().getDoorStatus()==DoorStatus.OPEN)
        {
            try {
                Thread.sleep(2000);
                System.out.println("Closing Gate!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elevatorCar.getDoor().setDoorStatus(DoorStatus.CLOSE);
            System.out.println("Elevator Door is  closed");
        }

    }

    @Override
    public void openDoor() {
        ElevatorCar elevatorCar=elevatorController.getElevatorCar();
        if(elevatorCar.getDoor().getDoorStatus()==DoorStatus.CLOSE)
        {
            try {
                Thread.sleep(2000);
                System.out.println("Attention: Opening gate!!");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            elevatorCar.getDoor().setDoorStatus(DoorStatus.OPEN);
            System.out.println("Elevator Door opened");
        }
    }

    @Override
    public void move() {
        elevatorController.setCurrentState(elevatorController.getMoveState());
        System.out.println("Elevator will be start moving");
        elevatorController.move();
    }
}
