package com.dnsgml.web;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class) // ①
@WebMvcTest
public class BaseBallGameTest {
    @Autowired //  ➂
    private MockMvc mvc; //  ➃

    private final static String _given = "123";

    @Test
    public void test_case1() throws Exception {
        String input = "321";
        String expected = "1S2B";

        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        //then
        assertThat( result ).isEqualTo( expected );
    }

    @Test
    public void test_case2() throws Exception {
        String input = "415";
        String expected = "1B";

        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        //then
        assertThat( result ).isEqualTo( expected );
    }

    @Test
    public void test_case3() throws Exception {
        String input = "123";
        String expected = "3S";

        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        //then
        assertThat( result ).isEqualTo( expected );
    }

    @Test
    public void test_case4() throws Exception {
        String input = "456";
        String expected = "(null)";

        BaseBallGame baseBallGame = new BaseBallGame();
        String result = baseBallGame.getScore( _given, input );

        //then
        assertThat( result ).isEqualTo( expected );
    }
}
