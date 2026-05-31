package healthcalc;
import healthcalc.exceptions.InvalidHealthDataException;

public interface BodySurfaceArea {

    float bodySurfaceArea(Person person) throws InvalidHealthDataException;
}


