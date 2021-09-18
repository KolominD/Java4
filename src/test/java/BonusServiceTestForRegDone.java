import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTestForRegDone {

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000_60;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }

    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000_60;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredNearBelowLimit() {
        BonusService service = new BonusService();

        long amount = 16634_00;
        boolean registered = true;
        long expected = 499;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }


    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredNearOverLimit() {
        BonusService service = new BonusService();

        long amount = 16677_00;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
    @org.junit.jupiter.api.Test
    void shouldCalculateForRegisteredZero() {
        BonusService service = new BonusService();

        long amount = 0;
        boolean registered = true;
        long expected = 0;

        long actual = service.calculate(amount, registered);

        assertEquals(expected, actual);
    }
}
