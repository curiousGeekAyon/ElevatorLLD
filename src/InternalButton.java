public class InternalButton {
    InternalButtontype internalButtontype;
    Integer floorNo;
    InternalDispatcher internalDispatcher;
    int elevatorId;
    public InternalButton(InternalButtontype internalButtontype, Integer floorNo,int elevatorId,InternalDispatcher internalDispatcher) {
        this.internalButtontype = internalButtontype;
        this.floorNo = floorNo;
        this.elevatorId=elevatorId;
        this.internalDispatcher=internalDispatcher;
    }

    public InternalButtontype getInternalButtontype() {
        return internalButtontype;
    }

    public void setInternalButtontype(InternalButtontype internalButtontype) {
        this.internalButtontype = internalButtontype;
    }

    public Integer getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(Integer floorNo) {
        this.floorNo = floorNo;
    }
    public void press(Direction direction){
        internalDispatcher.processRequest(direction,floorNo,elevatorId);
    }
}
