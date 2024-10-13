class TempOutOfRange extends Exception {
    public TempOutOfRange(String message) {
        super(message);
    }
}

class TempTooHigh extends TempOutOfRange {
    public TempTooHigh(int temp, int max) {
        super(temp + " degrees is too high. Max allowed is " + max);
    }
}

class TempTooLow extends TempOutOfRange {
    public TempTooLow(int temp, int min) {
        super(temp + " degrees is too low. Min allowed is " + min);
    }
}








// class TempOutOfRange extends Exception {
//     public TempOutOfRange(String message) {
//         super(message);
//     }
// }

// class TempTooHigh extends TempOutOfRange {
//     public TempTooHigh(String message) {
//         super(message);
//     }
// }

// class TempTooLow extends TempOutOfRange {
//     public TempTooLow(String message) {
//         super(message);
//     }
// }
