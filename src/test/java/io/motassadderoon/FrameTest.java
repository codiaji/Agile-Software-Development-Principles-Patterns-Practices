package io.motassadderoon;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FrameTest {
    Frame frame;

    @BeforeEach
    void setUp() {
        frame = new Frame();
    }

    @Test
    void testScoreNoThrows() {
        assertEquals(0, frame.score());
    }

    @Test
    void testAddOneThrow() {
        frame.add(6);
        assertEquals(6, frame.score());
    }
}
