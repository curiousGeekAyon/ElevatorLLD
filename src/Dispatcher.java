import java.util.List;

public abstract class Dispatcher {
    List<ElevatorController> controllerList;
    public abstract void processRequest(Direction direction,int floorNo,Integer id);

    public List<ElevatorController> getControllerList() {
        return controllerList;
    }

    public void setControllerList(List<ElevatorController> controllerList) {
        this.controllerList = controllerList;
    }
}
