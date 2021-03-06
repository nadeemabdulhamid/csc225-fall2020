import static org.junit.Assert.*;
import org.junit.*;

public class FamTreeTests {

    IFamTree bart = new Person("Bart", 1985, new Person("Marge", 1956, new Unknown(), new Unknown()),
            new Person("Homer", 1956, new Unknown(), new Person("Abe", 1903, new Unknown(), new Unknown())));

    IFamTree bart2 = new Person("Bart", 1958, new Person("Marge", 1965),
            new Person("Homer", 1956, new Unknown(), new Person("Abe", 1903)));

    IFamTree enid = new Person("Enid", 1904);
    IFamTree edward = new Person("Edward", 1902);
    IFamTree emma = new Person("Emma", 1906);
    IFamTree eustace = new Person("Eustace", 1907);

    IFamTree david = new Person("David", 1925);
    IFamTree daisy = new Person("Daisy", 1927);
    IFamTree dana = new Person("Dana", 1933);
    IFamTree darcy = new Person("Darcy", 1930, emma, eustace);
    IFamTree darren = new Person("Darren", 1935, enid, new Unknown());
    IFamTree dixon = new Person("Dixon", 1936);

    IFamTree clyde = new Person("Clyde", 1955, daisy, david);
    IFamTree candace = new Person("Candace", 1960, dana, darren);
    IFamTree cameron = new Person("Cameron", 1959, new Unknown(), dixon);
    IFamTree claire = new Person("Claire", 1956, darcy, new Unknown());

    IFamTree bill = new Person("Bill", 1980, candace, clyde);
    IFamTree bree = new Person("Bree", 1981, claire, cameron);

    IFamTree andrew = new Person("Andrew", 2001, bree, bill);

    @Test
    public void testWellFormed() {
        assertTrue(bart.wellFormed());
        assertFalse(bart2.wellFormed());
    }

    @Test
    public void testCountAncestor() {
        assertEquals(0, new Unknown().countAncestors());
        assertEquals(3, bart.countAncestors());
    }

    @Test
    public void testCountName() {
        assertEquals(1, new Person("Bart", 1985).countName("Bart"));
        assertEquals(0, new Person("Abe", 1903).countName("Bart"));
        assertEquals(0, new Unknown().countName("Bart"));
        assertEquals(1, bart.countName("Abe"));
        assertEquals(0, bart.countName("Lucy"));
        assertEquals(2, new Person("Homer", 1956, new Unknown(), bart2).countName("Homer"));
    }
}
