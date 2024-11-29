import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class InputService {
    Set<Integer> requestUp;
    Set<Integer>requestDown;
    ElevatorCar elevatorCar;
    public Set<Integer> getRequestUp() {
        return requestUp;
    }
    public InputService(ElevatorCar elevatorCar){
        requestUp=new HashSet<>();
        requestDown=new HashSet<>();
        this.elevatorCar=elevatorCar;
    }

    public Set<Integer> getRequestDown() {
        return requestDown;
    }
    public void inputSeviceProvider(Direction direction,int floorNo)
    {
        if(direction==Direction.DOWN)
        {
            if(getRequestDown().contains(floorNo))
            {
                System.out.print("Hey please enter ur destination floor");
                Scanner sc=new Scanner(System.in);
                int destfloorNo=sc.nextInt();
                elevatorCar.floorButtons.get(destfloorNo-1).press(direction);
            }
        }
        else{
            if(getRequestUp().contains(floorNo))
            {
                System.out.print("Hey please enter ur destination floor: ");
                Scanner sc=new Scanner(System.in);
                int destfloorNo=sc.nextInt();
                elevatorCar.floorButtons.get(destfloorNo-1).press(direction);
            }
        }
    }
}
