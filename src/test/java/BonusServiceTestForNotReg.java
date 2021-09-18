import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTestForNotReg {

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegNearBelowLimit() {
        BonusService service = new BonusService();

        long amount = 49999_00;
        boolean registered = false;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredNearOverLimit() {
        BonusService service = new BonusService();

        long amount = 50100_00;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForNotRegZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = false;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}