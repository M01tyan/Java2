import java.lang.reflect.*;
import static java.lang.System.out;
import static java.lang.System.err;

public class RunSimpleTests {
  public static void main(String[] args) throws Exception {
    int passed = 0, failed = 0;
    for (Method m : Class.forName(args[0]).getMethods()) {
       if (m.isAnnotationPresent(SimpleTest.class)) {
        try {
          m.invoke(null);
          passed++;
        } catch (Throwable ex) {
          System.out.printf("%s failed: %s %n", m.getName(), ex.getCause());
          failed++;
        }
      }
    }
    System.out.printf("%d passed out of %d tested\n",passed, passed + failed);
  }
}
