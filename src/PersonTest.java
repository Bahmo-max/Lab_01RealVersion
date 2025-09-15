import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PersonTest {

    Person p1 = new Person("John", "Doe", "000001", "Mr", 2003);
    Person p2 = new Person("Johnny", "Test", "000002", "Mr", 2002);
    Person p3 = new Person("Charles", "Xavier", "000003", "Prof", 1950);

    @Test
    void fullName() {
        assertEquals("John Doe", p1.fullName());
        assertEquals("Johnny Test", p2.fullName());
        assertEquals("Charles Xavier", p3.fullName());
    }

    @Test
    void formalName() {
        assertEquals("Mr John Doe", p1.formalName());
        assertEquals("Mr Johnny Test", p2.formalName());
        assertEquals("Prof Charles Xavier", p3.formalName());
    }

    @Test
    void getAge() {
        int currentYear = java.time.Year.now().getValue();
        assertEquals(currentYear - 2003, p1.getAge());
        assertEquals(currentYear - 2002, p2.getAge());
        assertEquals(currentYear - 1950, p3.getAge());
    }

    @Test
    void testGetAge() {
        assertEquals(20, p1.getAge(2023));
        assertEquals(21, p2.getAge(2023));
        assertEquals(73, p3.getAge(2023));
    }

    @Test
    void toCSV() {
        assertEquals("000001,John,Doe,Mr,2003", p1.toCSV());
        assertEquals("000002,Johnny,Test,Mr,2002", p2.toCSV());
        assertEquals("000003,Charles,Xavier,Prof,1950", p3.toCSV());
    }

    @Test
    void toJSON() {
        assertEquals("{\"ID\":\"000001\",\"firstName\":\"John\",\"lastName\":\"Doe\",\"title\":\"Mr\",\"YOB\":2003}", p1.toJSON());
        assertEquals("{\"ID\":\"000002\",\"firstName\":\"Johnny\",\"lastName\":\"Test\",\"title\":\"Mr\",\"YOB\":2002}", p2.toJSON());
        assertEquals("{\"ID\":\"000003\",\"firstName\":\"Charles\",\"lastName\":\"Xavier\",\"title\":\"Prof\",\"YOB\":1950}", p3.toJSON());
    }

    @Test
    void toXML() {
        assertEquals("<Person><ID>000001</ID><FirstName>John</FirstName><LastName>Doe</LastName><Title>Mr</Title><YOB>2003</YOB></Person>", p1.toXML());
        assertEquals("<Person><ID>000002</ID><FirstName>Johnny</FirstName><LastName>Test</LastName><Title>Mr</Title><YOB>2002</YOB></Person>", p2.toXML());
        assertEquals("<Person><ID>000003</ID><FirstName>Charles</FirstName><LastName>Xavier</LastName><Title>Prof</Title><YOB>1950</YOB></Person>", p3.toXML());
    }

    @Test
    void testEquals() {
        Person p1Copy = new Person("John", "Doe", "000001", "Mr", 2003);
        assertTrue(p1.equals(p1Copy));
        assertFalse(p1.equals(p2));
    }
}
