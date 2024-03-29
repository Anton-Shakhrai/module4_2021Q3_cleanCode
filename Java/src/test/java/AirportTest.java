import planes.ExperimentalPlane;
import models.ClassificationLevel;
import models.ExperimentalType;
import models.MilitaryType;
import org.testng.Assert;
import org.testng.annotations.Test;
import planes.MilitaryPlane;
import planes.PassengerPlane;
import planes.Plane;

import java.util.Arrays;
import java.util.List;

public class AirportTest {
    private static List<Plane> planes = Arrays.asList(
            new PassengerPlane("Boeing-737", 900, 12000, 60500, 164),
            new PassengerPlane("Boeing-737-800", 940, 12300, 63870, 192),
            new PassengerPlane("Boeing-747", 980, 16100, 70500, 242),
            new PassengerPlane("Airbus A320", 930, 11800, 65500, 188),
            new PassengerPlane("Airbus A330", 990, 14800, 80500, 222),
            new PassengerPlane("Embraer 190", 870, 8100, 30800, 64),
            new PassengerPlane("Sukhoi Superjet 100", 870, 11500, 50500, 140),
            new PassengerPlane("Bombardier CS300", 920, 11000, 60700, 196),
            new MilitaryPlane("B-1B Lancer", 1050, 21000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("B-2 Spirit", 1030, 22000, 70000, MilitaryType.BOMBER),
            new MilitaryPlane("B-52 Stratofortress", 1000, 20000, 80000, MilitaryType.BOMBER),
            new MilitaryPlane("F-15", 1500, 12000, 10000, MilitaryType.FIGHTER),
            new MilitaryPlane("F-22", 1550, 13000, 11000, MilitaryType.FIGHTER),
            new MilitaryPlane("C-130 Hercules", 650, 5000, 110000, MilitaryType.TRANSPORT),
            new ExperimentalPlane("Bell X-14", 277, 482, 500, ExperimentalType.HIGHALTITUDE, ClassificationLevel.SECRET),
            new ExperimentalPlane("Ryan X-13 Vertijet", 560, 307, 500, ExperimentalType.VTOL, ClassificationLevel.TOPSECRET)
    );

    Airport airport = new Airport(planes); // 'airport' variable common for all tests. Was located out of tests bounds.

  @Test
  public void testMilitaryPlanesHasTransportType() {
    List<MilitaryPlane> transportMilitaryPlanes = airport.getTransportMilitaryPlanes();
    for (planes.MilitaryPlane transportMilitaryPlane : transportMilitaryPlanes) {
        Assert.assertEquals(transportMilitaryPlane.getMilitaryType(), MilitaryType.TRANSPORT);
        }
    }

    @Test
    public void testPassengerPlaneHasMaxPassengersCapacity() {
//        System.out.println is removed from test
        PassengerPlane expectedPlaneWithMaxPassengersCapacity = airport.getPassengerPlaneWithMaxPassengersCapacity();
        Assert.assertEquals(expectedPlaneWithMaxPassengersCapacity.getPassengersCapacity(), 242);
    }

    @Test
    public void testSortingByMaxLoadCapacity() {
        List<? extends Plane> planesSortedByMaxLoadCapacity = airport.sortByMaxLoadCapacity().getPlanes();
        for (int i = 0; i < planesSortedByMaxLoadCapacity.size() - 1; i++) {
            Assert.assertTrue(planesSortedByMaxLoadCapacity.get(i).getMaxLoadCapacity() <=
                planesSortedByMaxLoadCapacity.get(i+1).getMaxLoadCapacity());
            }
        }

    @Test
    public void testMilitaryPlanesHasAtLeastOneBomber() {
        List<MilitaryPlane> bomberMilitaryPlanes = airport.getBomberMilitaryPlanes(); // loops and conditions removed
        Assert.assertFalse(bomberMilitaryPlanes.isEmpty());
    }

    @Test
    public void testExistanceUnclassifiedPlanes(){
        List<ExperimentalPlane> experimentalPlanes = airport.getExperimentalPlanes(); // loops and conditions removed
        for (planes.ExperimentalPlane experimentalPlane : experimentalPlanes) {
        Assert.assertNotEquals(experimentalPlane.getClassificationLevel(), ClassificationLevel.UNCLASSIFIED);
    }
        }
}
