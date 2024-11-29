public class FloorButton extends InternalButton{
    public FloorButton( Integer floorNo,int elevatorId,InternalDispatcher internalDispatcher) {
        super(InternalButtontype.FLOOR, floorNo,elevatorId,internalDispatcher);
    }
    public void press(Direction direction)
    {
        internalDispatcher.processRequest(direction,floorNo,elevatorId);
    }
}
