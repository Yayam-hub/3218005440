package stringmacth.com;

import java.lang.String;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;

import org.junit.jupiter.params.provider.Arguments;

import org.junit.jupiter.params.provider.MethodSource;




import java.io.IOException;

import java.time.Duration;

import java.util.concurrent.atomic.AtomicReference;

import java.util.stream.Stream;



import static org.junit.jupiter.api.Assertions.*;



 public class SMatchTest {


    @ParameterizedTest

    @MethodSource("TestData")

    void match(String first,String second) throws TextException {

        SMatch match= new SMatch(first,second);

        match.PreProgress();

        AtomicReference<Double> ans = new AtomicReference<>(0.0);

        assertTimeout(Duration.ofSeconds(4),()-> ans.set(match.Match()));

        assertTrue(0<=ans.get() && ans.get()<=1);

        System.out.printf("Similarity: %.2f",ans.get());

    }



    @SuppressWarnings("unused")
	@ParameterizedTest

    @MethodSource("EmptyData")

    void emptyTest(String first,String second) throws TextException{

        SMatch match= new SMatch(first,second);

        match.PreProgress();

        AtomicReference<Double> ans = new AtomicReference<>(0.0);

        assertThrows(TextException.class,()->match.Match(),"Text can't be empty");

    }



@Test

    private static Stream<Arguments> TestData() throws IOException {

        java.lang.String[] fileNames = new java.lang.String[]{

                "orig_0.8_add.txt",

                "orig_0.8_del.txt",

                "orig_0.8_dis_1.txt",

                "orig_0.8_dis_10.txt",

                "orig_0.8_dis_15.txt",

        };

        java.lang.String base = System.getProperty("user.dir")+ "/src/test1/";

        java.lang.String first = base + "orig.txt";

        return Stream.of(

                Arguments.of(FileOperation.ReadToString(first), FileOperation.ReadToString(base+fileNames[0])),

                Arguments.of(FileOperation.ReadToString(first), FileOperation.ReadToString(base+fileNames[1])),

                Arguments.of(FileOperation.ReadToString(first), FileOperation.ReadToString(base+fileNames[2])),

                Arguments.of(FileOperation.ReadToString(first), FileOperation.ReadToString(base+fileNames[3])),

                Arguments.of(FileOperation.ReadToString(first), FileOperation.ReadToString(base+fileNames[4]))

        );

    }


   @Test 
    private static Stream<Arguments> EmptyData() throws IOException{

        java.lang.String[] fileNames = new java.lang.String[]{

                "Empty.txt",

        };

        java.lang.String base = System.getProperty("user.dir")+ "/src/test1/";

        java.lang.String first = base + "orig.txt";

        return Stream.of(

                Arguments.of(FileOperation.ReadToString(first), FileOperation.ReadToString(base+fileNames[0]))

                );

    }

}