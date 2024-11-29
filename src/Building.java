import java.util.ArrayList;
import java.util.List;

public class Building {
    public List<Floor> getFloorList() {
        return floorList;
    }

    public void setFloorList(List<Floor> floorList) {
        this.floorList = floorList;
    }

    List<Floor> floorList;
    public Building(int floors,ExternalDispatcher externalDispatcher)
    {
        floorList=new ArrayList<>();
        for(int i=0;i<floors;i++)
        {
            floorList.add(new Floor(i,externalDispatcher));
        }
    }
}
