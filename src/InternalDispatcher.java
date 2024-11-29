import java.util.ArrayList;

public class InternalDispatcher extends  Dispatcher{

    public InternalDispatcher()
    {
//        controllerList=new ArrayList<>();
    }
    public void processRequest(Direction direction, int floorNo,Integer id) {
        controllerList.get(id).handelRequest(direction,floorNo,false);
    }
}
