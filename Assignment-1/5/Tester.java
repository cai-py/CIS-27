public class Tester {
    public static void main(String[] args) {
        Thermostat myTermostat = new Thermostat(0, 100);

        try {
            myTermostat.setTemp(-10);
        } catch (TempOutOfRange e) {
            System.out.println("ERROR: " + e.getMessage());
        } 

        try {
            myTermostat.setTemp(68);
        } catch (TempOutOfRange e) {
            System.out.println("ERROR: " + e.getMessage());
        } 

        try {
            myTermostat.setTemp(200);
        } catch (TempOutOfRange e) {
            System.out.println("ERROR: " + e.getMessage());
        } 
    }
}

