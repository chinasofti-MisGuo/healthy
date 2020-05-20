package com.mongolia.test;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Date;

/**
 * @author Dong.w
 */
public class UserTest {

    @Test
    public void birthdayTest() throws Exception{
        long l = LocalDate.now().toEpochDay();
        LocalDate localDate = LocalDate.of(1999, 1,9);
        long day = localDate.toEpochDay();
        long l1 = (l - day) / 365;
        System.out.println(l1);
    }

}
