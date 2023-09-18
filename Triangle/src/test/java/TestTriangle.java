import org.testng.Assert;
import org.testng.annotations.*;

public class TestTriangle {

    @BeforeClass
    public void setup() {
        System.out.println("Setup");
    }

    @AfterClass
    public void tearDown() {
        System.out.println("Tear down");
    }

    @BeforeMethod
    public void beforeEachTest() {
        System.out.println("Before each test");
    }

    @AfterMethod
    public void afterEachTest() {
        System.out.println("After each test");
    }

    //равносторонний

    @DataProvider(name = "triangleEquilateral")
    public Object[][] getTriangleEquilateral() {
        return new Object[][]{
                {1, 1, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE},
        };
    }


    @Test(dataProvider = "triangleEquilateral")
    public void testEquality(int side1, int side2, int side3) {
        Assert.assertEquals(side1, side2);
        Assert.assertEquals(side2, side3);
        Assert.assertEquals(side1, side3);
    }

    //    равнобедренный
    @DataProvider(name = "triangleIsosceles")
    public Object[][] getTriangleIsosceles() {
        return new Object[][]{
                {1, 2, 2},
//                {2, 1, 2},
//                {2, 2, 1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE - 1},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.MAX_VALUE},
        };
    }

    @Test(dataProvider = "triangleIsosceles")
    public void testIsosceles(int side1, int side2, int side3) {
        boolean areSidesEqual = ((side1 == side2) || (side2 == side3) || (side3 == side1));
        Assert.assertTrue(areSidesEqual, "Two sides of the triangle must be equal");
    }

    //    разносторонний
    @DataProvider(name = "triangleScalene")
    public Object[][] getTriangleScalene() {
        return new Object[][]{
                {2, 3, 4},
//                {3, 2, 4},
//                {3, 4, 2},
//                {2, 4, 3},
//                {4, 3, 2},
//                {4, 2, 3},
                {Integer.MAX_VALUE, Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2},
//                {Integer.MAX_VALUE, Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1},
//                {Integer.MAX_VALUE - 1, Integer.MAX_VALUE, Integer.MAX_VALUE - 2},
//                {Integer.MAX_VALUE - 2, Integer.MAX_VALUE, Integer.MAX_VALUE - 1},
//                {Integer.MAX_VALUE - 1, Integer.MAX_VALUE - 2, Integer.MAX_VALUE},
//                {Integer.MAX_VALUE - 2, Integer.MAX_VALUE - 1, Integer.MAX_VALUE},
        };
    }

    @Test(dataProvider = "triangleScalene")
    public void testScalene(int side1, int side2, int side3) {
        boolean areSidesDifferent = (side1 != side2 && side2 != side3 && side3 != side1);
        Assert.assertTrue(areSidesDifferent, "At least two sides of the triangle must be different");
    }


}


