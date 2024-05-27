package com.dnsgml.admin.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@ExtendWith(SpringExtension.class) // ①
@WebMvcTest
public class BaseBallGameTest {
    @Autowired //  ➂
    private MockMvc mvc; //  ➃

    private final static String _given = "123";

    @Test
    public void test_case1() throws Exception {
        String input = "321";
        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        System.out.println( result );
    }

    @Test
    public void test_case2() throws Exception {
        String input = "415";
        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        System.out.println( result );
    }

    @Test
    public void test_case3() throws Exception {
        String input = "123";
        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        System.out.println( result );
    }

    @Test
    public void test_case4() throws Exception {
        String input = "456";
        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        System.out.println( result );
    }
}
