public class DoorButton extends InternalButton{
    public DoorButton(Integer floorNo,int elevatorId,InternalDispatcher internalDispatcher) {
        super(InternalButtontype.DOOR, floorNo,elevatorId,internalDispatcher);
    }
}
