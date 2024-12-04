import java.util.*;

public class ElevatorController {
    ElevatorCar elevatorCar;
    Direction direction;
    PriorityQueue<Integer>downQueue;
    PriorityQueue<Integer>upQueue;
    List<Integer> pendingDown;
    List<Integer>pendingUp;
    ElevatorControllerState currentState;
    IdleState idleState;
    MoveState moveState;
    int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ElevatorControllerState getCurrentState() {
        return currentState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
        elevatorCar.setFloorNo(currentFloor);
    }

    int currentFloor;
    InputService inputService;
    public ElevatorController(Direction direction,int id,int floorCount) {
        this.elevatorCar = new ElevatorCar(id,direction,floorCount);
        this.direction = direction;
        this.id=id;
        downQueue =new PriorityQueue<>(Collections.reverseOrder());
        upQueue =new PriorityQueue<>();
        pendingDown = new ArrayList<>();
        pendingUp = new ArrayList<>();
        this.currentFloor=0;
        this.idleState=new IdleState(this);
        this.moveState=new MoveState(this);
        currentState=idleState;
        inputService=new InputService(elevatorCar);
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        elevatorCar.setDirection(direction);
        this.direction = direction;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public void setCurrentState(ElevatorControllerState state) {
        this.currentState =state ;
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public ElevatorCar getElevatorCar() {
        return elevatorCar;
    }

    public void setElevatorCar(ElevatorCar elevatorCar) {
        this.elevatorCar = elevatorCar;
    }

    public PriorityQueue<Integer> getDownQueue() {
        return downQueue;
    }

    public void setDownQueue(PriorityQueue<Integer> downQueue) {
        this.downQueue = downQueue;
    }

    public PriorityQueue<Integer> getUpQueue() {
        return upQueue;
    }

    public void setUpQueue(PriorityQueue<Integer> upQueue) {
        this.upQueue = upQueue;
    }

    public List<Integer> getPendingDown() {
        return pendingDown;
    }

    public void setPendingDown(List<Integer> pendingDown) {
        this.pendingDown = pendingDown;
    }

    public List<Integer> getPendingUp() {
        return pendingUp;
    }

    public void setPendingUp(List<Integer> pendingUp) {
        this.pendingUp = pendingUp;
    }
    public void pauseAndResume()
    {
        currentState=idleState;
        currentState.openDoor();
        currentState.closeDoor();
        currentState=moveState;
    }
    public void move(){
        currentState.move();
    }

    public void handelRequest(Direction direction,int floorNo,boolean external)
    {
           handelRequestasPerDirection(direction,floorNo,external);
           moveifNotMoving();
    }
    public void moveifNotMoving()
    {
        if(currentState instanceof  IdleState)
            {
                this.move();
            }
    }

    private void handelRequestasPerDirection(Direction direction, int floorNo,boolean external) {
        if(direction==this.getDirection())
            {
                if(direction==Direction.UP)
                    {
                        if(external)
                        {
                            inputService.getRequestUp().add(floorNo);
                        }
                        if(upQueue.isEmpty()) {
                            if(currentFloor<=floorNo) {
                                if(external||currentFloor<floorNo) {
                                    upQueue.add(floorNo);
                                }
                                else if(currentFloor==floorNo)
                                {
                                    return;
                                }

                            }
                            else{
                                System.out.println("Unprocessable request to go floor no "+(floorNo+1)+" by moving up "+this.direction+" is the direction of elevator no "+this.id);
                            }
                        }
                        else if(upQueue.peek()<=floorNo) {
                            if(external||currentFloor<floorNo) {
                                upQueue.add(floorNo);
                            }
                            else if(currentFloor==floorNo)
                            {
                                return;
                            }
                    }
                        else{
                            if(upQueue.peek()>floorNo&&external)
                            {
                                pendingUp.add(floorNo);
                            }
                            else {
                                System.out.println("Unprocessable request to go floor no "+(floorNo+1)+" by moving up "+this.direction+" is the direction of elevator no "+this.id);
                            }
                        }
                    }
                else {
                    if (external) {
                        inputService.getRequestDown().add(floorNo);
                    }
                    if (downQueue.isEmpty()) {
                        if (currentFloor >= floorNo) {
                            if (external||currentFloor >floorNo) {
                                downQueue.add(floorNo);
                            } else if (currentFloor == floorNo) {
                                return;
                            }
                        }
                        else {
                            System.out.println("Unprocessable request to go floor no "+(floorNo+1)+" by moving down "+this.direction+" is the direction of elevator no "+this.id);
                        }
                    }
                    else if(downQueue.peek()>=floorNo) {
                        if (external||currentFloor > floorNo) {
                            downQueue.add(floorNo);
                        } else if (currentFloor == floorNo) {
                            return;
                        }
                    }
                        else{
                            if(downQueue.peek()>floorNo&&external)
                            {
                                pendingDown.add(floorNo);
                            }
                            else {
                                System.out.println("Unprocessable request to go floor no "+(floorNo+1)+" by moving down "+this.direction+" is the direction of elevator no "+this.id);
                            }
                        }
                    }
            }
        else{
            if(direction==Direction.UP)
            {
                pendingUp.add(floorNo);
            }
            else{
                pendingDown.add(floorNo);
            }
        }
    }
}
