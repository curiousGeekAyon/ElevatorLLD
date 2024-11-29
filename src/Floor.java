public class Floor {
    ExternalUpButton externalUpButton;
    ExternalDownButton externalDownButton;
    int floorId;

    public Floor(int floorId,ExternalDispatcher externalDispatcher) {
        this.floorId = floorId;
        externalDownButton=new ExternalDownButton(floorId,externalDispatcher);
        externalUpButton=new ExternalUpButton(floorId,externalDispatcher);
    }
}
