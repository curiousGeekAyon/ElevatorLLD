import java.util.ArrayList;
import java.util.List;

public class ElevatorEcoSystemBuilder {
    Building building;
    InternalDispatcher internalDispatcher;
    ExternalDispatcher externalDispatcher;

    public Building getBuilding() {
        return building;
    }

    public void setBuilding(Building building) {
        this.building = building;
    }

    public InternalDispatcher getInternalDispatcher() {
        return internalDispatcher;
    }

    public void setInternalDispatcher(InternalDispatcher internalDispatcher) {
        this.internalDispatcher = internalDispatcher;
    }

    public ExternalDispatcher getExternalDispatcher() {
        return externalDispatcher;
    }

    public void setExternalDispatcher(ExternalDispatcher externalDispatcher) {
        this.externalDispatcher = externalDispatcher;
    }

    public ElevatorEcoSystemBuilder(int floorCount, int elevatorCount)
        {
            internalDispatcher=new InternalDispatcher();
            List<ElevatorController> controllerList=new ArrayList<>();
            externalDispatcher=new ExternalDispatcher(elevatorCount);
            internalDispatcher.setControllerList(controllerList);
            externalDispatcher.setControllerList(controllerList);
            for(int i=0;i<elevatorCount;i++)
            {
                controllerList.add(new ElevatorController(Direction.UP,i,floorCount));
                ElevatorCar elevatorCar=controllerList.get(i).getElevatorCar();
                List<InternalButton>floorButtons=new ArrayList<>();
                for(int floor=0;floor<floorCount;floor++)
                    {
                        floorButtons.add(new FloorButton(floor,i,internalDispatcher));
                    }

                elevatorCar.setInternalButtons(floorButtons);
                elevatorCar.setDoorButton(new DoorButton(null,i,internalDispatcher));

            }
            building=new Building(floorCount,externalDispatcher);
        }
}
