import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        System.out.print("Hi please enter your desired floor Count: ");
        int floorCount=sc.nextInt();
        System.out.print("Please entire your desire elevatorCount: ");
        int elevatorCount=sc.nextInt();
        ElevatorEcoSystemBuilder elevatorEcoSystemBuilder=new ElevatorEcoSystemBuilder(floorCount,elevatorCount);
        Building building=elevatorEcoSystemBuilder.getBuilding();
        List<Floor> floorList=building.getFloorList();
        floorList.get(2).externalUpButton.press();
        floorList.get(0).externalDownButton.press();
        floorList.get(1).externalUpButton.press();
        floorList.get(3).externalDownButton.press();
    }
}