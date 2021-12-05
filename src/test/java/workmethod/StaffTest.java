package workmethod;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StaffTest {

    @Test
    void inter() {
        int a = 9;
        int b = 10;
        double res = 0;
        res = a + b;
        assertEquals(19, res);
    }

    @Test
    public void TestKMK() throws Exception {
        Сalculations сalculation = new Сalculations();
        double group = 5000;
        double value = 2.5;
        List<String> actual = сalculation.KMK(value,group);
        double X = 0.63 * group;
        double E = ((83.6 - X) / 100) * value;
        double MF = (value * X) / 100;
        double Y = value * 0.164;
        List<Double> expected = new ArrayList<>();
        expected.add(value);
        expected.add(group);
        expected.add(E);
        expected.add(MF);
        expected.add(Y);
        //assertArrayEquals(actual, expected);
    }



//    @Test
//    public void testFindMax() throws Exception {
//        List<Integer> numbers = Arrays.asList(1,2,38,3,6,83,78);
//        int max = DataService.findMax(numbers);
//
//        assertThat(max).isEqualTo(83);
//    }
//
//    @Test
//    public void testCalculator() throws Exception{
//        double result = DataService.Calculator(12,3,4);
//        // передаем что ожидеться и что получим
//        assertThat(19.0).isEqualTo(result);
//    }

//    List<Integer> numbers = Arrays.asList(1,2,38,3,6,83,78);
//    int max = DataService.findMax(numbers);
//
//    assertThat(max).isEqualTo(83);
}


//    @Test
//    void convertKmToMTest() {
//        final Map<String, ConvertRule> convertedRules = Map.of("km", new ConvertRule("km", Map.of("m", (double)1000)));
//        final BaseConverter baseConverter = new BaseConverter(convertedRules);
//        final UnitData convert = baseConverter.convert(new ConvertData(new UnitData("km", 10), "m"));
//        assertEquals(10000, convert.getValue());
//        assertEquals("m", convert.getName());
//    }
