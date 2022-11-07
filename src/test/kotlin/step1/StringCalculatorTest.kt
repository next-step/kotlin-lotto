package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

internal class StringCalculatorTest{

    @Test
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`(){
        assertAll(
            {assertThat(StringCalculator.calculate("")).isEqualTo(0)},
            {assertThat(StringCalculator.calculate("null")).isEqualTo(0)}
        )
    }
}