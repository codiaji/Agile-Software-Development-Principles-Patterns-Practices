package io.motassadderoon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ThrowTest {
    Throw aThrow;

    @BeforeEach
    void setUp() {
        aThrow = new Throw();
    }

    @Test
    void throwBall() {
        aThrow.throwBall(6);
        assertEquals(6, aThrow.getCountOfKnockedPins());
    }
}