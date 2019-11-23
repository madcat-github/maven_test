import org.junit.Test;

public class TestMain {

    @Test
    public void print() {
        System.out.println("#######################################");
    }
    @Test
    public void printClass() {
        System.out.println(this.getClass().getCanonicalName());
    }

    public static void main(String[] args) {

        System.out.println("This is my first testMain");
    }
}
