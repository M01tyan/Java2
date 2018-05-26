import java.io.IOException;
import java.lang.annotation.*;
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface SimpleTest{}

public class ExampleCode1 {
    @SimpleTest
    public static void testMethod1() {
    }

    @SimpleTest
    public static void testMethod2() {
	    throw new RuntimeException("Test2 should fail");
    }

    @SimpleTest
    public static void testMethod3() {
	// Test3 should fail
	    int a = 1 / 0;
    }

}
