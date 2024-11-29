public class ElevatorSelectingStrategy {
    //TODO
    int curr=1;
    int elevatorCount;
    public ElevatorSelectingStrategy(int elevatorCount)
        {
            this.elevatorCount=elevatorCount;
        }
    public int selectElevatorId(int floorNo) {
        while (true) {
            if (curr % 2 == 0 && floorNo%2==0)
            {
                return curr;
            }
            else if(curr % 2 != 0 && floorNo%2!=0)
            {
                return curr;
            }
            curr++;
            curr%=elevatorCount;
        }
    }
}
