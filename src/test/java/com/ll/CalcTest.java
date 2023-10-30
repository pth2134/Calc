package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class CalcTest {
    @Test
    @DisplayName("Calc의 run메소드는 int를 리턴한다.")
    void t1(){
        int r = Calc.run("2*2");
    }
    @Test
    @DisplayName("10 + 10 = 20")
    void t2() {
        int rs = Calc.run("10 + 10");
        assertThat(rs).isEqualTo(20);
    }
}
