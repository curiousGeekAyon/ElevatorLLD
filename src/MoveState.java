import java.util.List;
import java.util.PriorityQueue;

public class MoveState extends ElevatorControllerState{

    public MoveState(ElevatorController elevatorController)
    {
        this.elevatorController=elevatorController;
    }
    @Override
    public void openDoor() {
        System.out.println("Hey ,elevator is moving ,openningDoor is not allowed");
    }

    @Override
    public void closeDoor() {
        System.out.println("Door is closed already");
    }

    @Override
    public void move() {
        Direction direction=elevatorController.getDirection();
        if(direction==Direction.DOWN)
        {
          moveDown();
        }
        if(direction==Direction.UP)
        {
            moveUp();
        }
    }
    public void moveDown()
    {
            ElevatorCar elevatorCar=elevatorController.getElevatorCar();
            elevatorCar.setDirection(Direction.DOWN);
            PriorityQueue<Integer>currRequestQueue=elevatorController.getDownQueue();
            if(currRequestQueue.isEmpty()&&elevatorController.getUpQueue().isEmpty())
            {
                elevatorController.setCurrentState(elevatorController.idleState);
                System.out.println("Elevator is now in idle state at "+elevatorCar.getFloorNo()+"th floor");
                return;
            }
            elevatorController.setDirection(Direction.DOWN);
            InputService inputService=elevatorController.inputService;
            while(!currRequestQueue.isEmpty())
            {
                int floorNo=currRequestQueue.poll();
                System.out.println("Elevator no "+elevatorController.getId()+" Arrived at floor no "+floorNo+"by moving down");
                elevatorController.pause();
                elevatorController.setCurrentFloor(floorNo);
                inputService.inputSeviceProvider(Direction.DOWN,floorNo);
                elevatorController.resume();
            }
            if(!elevatorController.getPendingDown().isEmpty())
            {   List<Integer> pendingFloors=elevatorController.getPendingDown();
                for(int floor:pendingFloors)
                    {
                        currRequestQueue.add(floor);
                    }
            }
            moveUp();
    }

    private void moveUp() {
        ElevatorCar elevatorCar=elevatorController.getElevatorCar();
        PriorityQueue<Integer>currRequestQueue=elevatorController.getUpQueue();
        elevatorCar.setDirection(Direction.UP);
        if(currRequestQueue.isEmpty()&&elevatorController.getDownQueue().isEmpty())
        {
            elevatorController.setCurrentState(elevatorController.idleState);
            System.out.println("Elevator is now in idle state at "+elevatorCar.getFloorNo()+"th floor");
            return;
        }
        elevatorController.setDirection(Direction.UP);
        InputService inputService=elevatorController.inputService;
        while(!currRequestQueue.isEmpty())
            {
                int floorNo=currRequestQueue.poll();
                System.out.println("Elevator no "+elevatorController.getId()+" Arrived at floor no "+(floorNo+1)+" by moving up");
                elevatorController.pause();
                elevatorController.setCurrentFloor(floorNo);
                inputService.inputSeviceProvider(Direction.UP,floorNo);
                elevatorController.resume();
            }
        if(!elevatorController.getPendingUp().isEmpty())
        {   List<Integer> pendingFloors=elevatorController.getPendingUp();
            for(int floor:pendingFloors)
            {
                currRequestQueue.add(floor);
            }
        }
        moveDown();
    }
}
