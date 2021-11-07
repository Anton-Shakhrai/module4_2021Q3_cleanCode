package planes;

import models.ClassificationLevel;
import models.ExperimentalType;

import java.util.Objects;

public class ExperimentalPlane extends Plane{ // 'experimentalPlane' replaced by 'ExperimentalPlane'

    private ExperimentalType experimentalType; // 'type' replaced by 'experimentalType'
    private ClassificationLevel classificationLevel;

    public ExperimentalPlane(String planeModel, int maxSpeed, int maxFlightDistance, int maxLoadCapacity, ExperimentalType experimentalType, ClassificationLevel classificationLevel) {
        super(planeModel, maxSpeed, maxFlightDistance, maxLoadCapacity);
        this.experimentalType = experimentalType;
        this.classificationLevel = classificationLevel;
    }

    public ClassificationLevel getClassificationLevel() {
        return classificationLevel;
    }

    public ExperimentalType getExperimentalType() {
        return experimentalType;
    }

    public void setClassificationLevel(ClassificationLevel classificationLevel) {
    this.classificationLevel = classificationLevel;
    }

    @Override
    public String toString() {
        return super.toString().replace("}",
            ", \nexperimental type=" + experimentalType +
                ", \nclassification level=" + classificationLevel +
                "}\n");
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), experimentalType, classificationLevel);
    }
}
