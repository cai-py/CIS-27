public class Thermostat {
    private int min;
    private int max;
    private int currentTemp;

    public Thermostat(int min, int max) {
        this.min = min;
        this.max = max;
    }
    
    // get methods
    public int getMinTemp() {
        return min;
    }
    public int getMaxTemp() {
        return max;
    }
    public int getTemp() {
        return currentTemp;
    }

    // set methods
    public void setTemp(int temp) throws TempOutOfRange {
        //this.temp = temp;

        if (temp < min) {
            throw new TempTooLow(temp, min);
        } else if (temp > max) {
            throw new TempTooHigh(temp, max);
        } else {
            currentTemp = temp;
            System.out.println("Current Temperature: " + currentTemp);
        }

        // if (temp < min) {
        //     // throw temptoohigh error
        //     throw new TempTooLow(temp + " degrees is too low. Min allowed is " + min);
        // } else if (temp > max) {
        //     // throw temp too low error
        //     throw new TempTooHigh(temp + " degrees is too high.");
        // } else {
        //     currentTemp = temp;
        //     System.out.println("Current Temperature: " + currentTemp);
        // }
    }


}
