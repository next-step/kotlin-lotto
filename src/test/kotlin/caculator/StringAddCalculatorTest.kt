package caculator

import caculator.ui.Input
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class StringAddCalculatorTest {
    @ParameterizedTest
    @EmptySource
    fun `입력 값이 비었을 때 0을 반환한다`(text: String) {
        assertThat(StringAddCalculator(Input("")).calculate()).isZero()
    }

    @Test
    fun `토큰 중에 빈값이 있을 때 0으로 처리 된다`() {
        assertAll(
            "토큰 중에 빈값이 있을 때 0으로 처리 된다",
            { assertThat(StringAddCalculator(Input("1::4")).calculate()).isEqualTo(5) },
            { assertThat(StringAddCalculator(Input("1:::")).calculate()).isEqualTo(1) },
            { assertThat(StringAddCalculator(Input(":::8")).calculate()).isEqualTo(8) }
        )
    }

    @Test
    fun `기본 구분자로 계산한다`() {
        assertAll(
            "기본 구분자로 계산한다",
            { assertThat(StringAddCalculator(Input("1:5:10")).calculate()).isEqualTo(16) },
            { assertThat(StringAddCalculator(Input("100,200:300")).calculate()).isEqualTo(600) },
            { assertThat(StringAddCalculator(Input("7,10,50")).calculate()).isEqualTo(67) }
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "5", "100", "500", "0"])
    fun `숫자만 넣으면 해당 숫자가 결과값이 된다`(inputString: String) {
        assertThat(StringAddCalculator(Input(inputString)).calculate()).isEqualTo(inputString.toInt())
    }

    @ParameterizedTest
    @ValueSource(strings = ["//@\n20@5@7", "//!\n20!5!7", "//d\n20d5d7"])
    fun `커스텀 구분자로 계산한다`(inputString: String) {
        assertThat(StringAddCalculator(Input(inputString)).calculate()).isEqualTo(32)
    }
}
