package step1

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class StringCalculatorTest{

    @Test
    fun `빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다`(){
        assertAll(
            {assertThat(StringCalculator.calculate("")).isEqualTo(0)},
            {assertThat(StringCalculator.calculate(null)).isEqualTo(0)}
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "1", "2", "100000", "200000"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String){
        assertThat(StringCalculator.calculate(input)).isEqualTo(input.toInt())
    }

    @Test
    fun `기본 구분자를 가지는 문자열을 전달하는 경우 구분자를 기준으로 분리한 숫자의 합을 계산한다`() {
        assertThat(StringCalculator.calculate("1,2:3")).isEqualTo(6)
    }

    @Test
    fun `커스텀 구분자를 가지는 문자열의 각 숫자 합을 계산한다`(){
        assertThat(StringCalculator.calculate("//;\\n1;2;3")).isEqualTo(6)
    }
}