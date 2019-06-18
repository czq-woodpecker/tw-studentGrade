package com.tw.command;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author: woodpecker
 * @Date: 2019/6/18 15:13
 */
public class GenerateStuGradeCommandTest {
    private GenerateStuGradeCommand command;

    @Before
    public void init() {
        command = new GenerateStuGradeCommand();
    }

    @Test
    public void formatDoubleNumber() {
        String numberStr = command.formatDoubleNumber(100.00);
        assertTrue((100 + "").equals(numberStr));
    }
}