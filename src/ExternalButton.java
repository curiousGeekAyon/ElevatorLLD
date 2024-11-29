public class ExternalButton {
    Direction direction;
    int floorId;
    ExternalDispatcher externalDispatcher;
    public ExternalButton(Direction direction, int floorId,ExternalDispatcher externalDispatcher) {
        this.direction = direction;
        this.floorId = floorId;
        this.externalDispatcher=externalDispatcher;
    }
    public void press(){
        externalDispatcher.processRequest(direction,floorId,null);
    }
}
