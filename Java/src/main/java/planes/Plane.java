package planes; // 'Planes' is replaced by 'planes' according to Code Convention

import java.util.Objects;

public abstract class Plane { // reordered 'public' and 'abstract'
    String planeModel; // 'model' is renamed to 'planeModel' because it is not clear what model is used for.
    private int maxSpeed;
    private int maxFlightDistance;
    private int maxLoadCapacity;

    public Plane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity) {
        this.planeModel = planeModel;
        this.maxSpeed = maxSpeed;
        this.maxFlightDistance = maxFlightDistance;
        this.maxLoadCapacity = maxLoadCapacity;
    }

    public String getModel() {
        return planeModel;
    }

    public int getMaxSpeed() {  // 'getMS' abbreviation, which is unclear. Replaced by 'getMaxSpeed'
        return maxSpeed;
    }

    public int getMaxFlightDistance() { // 'getMaxFlightDistance' Hungarian notation. Replaced by 'getMaxFlightDistance'
        return maxFlightDistance;
    }

    public int getMaxLoadCapacity() {  // 'getMinLoadCapacity' replaced by 'getMaxLoadCapacity'
        return maxLoadCapacity; // 'result' variable is removed
    }

    @Override
    public String toString() {
        return "Plane{" +
                "\nmodel='" + planeModel + '\'' +
                ", \nmaxSpeed=" + maxSpeed +
                ", \nmaxFlightDistance=" + maxFlightDistance +
                ", \nmaxLoadCapacity=" + maxLoadCapacity +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Plane)) return false;
        Plane plane = (Plane) o;
        return maxSpeed == plane.maxSpeed &&
                maxFlightDistance == plane.maxFlightDistance &&
                maxLoadCapacity == plane.maxLoadCapacity &&
                Objects.equals(planeModel, plane.planeModel);
    }

    @Override
    public int hashCode() {
        return Objects.hash(planeModel, maxSpeed, maxFlightDistance, maxLoadCapacity);
    }
}
