import java.util.ArrayList;

public class ExternalDispatcher extends Dispatcher{


    ElevatorSelectingStrategy elevatorSelectingStrategy;

    public ExternalDispatcher(int elevatorCount)
        {
//            controllerList=new ArrayList<>();
            elevatorSelectingStrategy=new ElevatorSelectingStrategy(elevatorCount);
        }
    public void processRequest(Direction direction, int floorNo,Integer id) {
        int elevatorControllerId=elevatorSelectingStrategy.selectElevatorId(floorNo);
        controllerList.get(elevatorControllerId).handelRequest(direction,floorNo,true);
    }

}
