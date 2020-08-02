package textcalculator

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class TextCalculatorTest {
    @Test
    fun `execute() 입력을 받아서 합계 출력`() {
        val io = MockUpIOManager("1,2:3,4:5:10")
        TextCalculator(io, Parser()).execute()

        assertThat(io.toString()).isEqualTo("25")
    }

    @Test
    fun `execute() 커스텀 구분자 있는 정상 케이스일 때 합 출력`() {
        val io = MockUpIOManager("//;\\n1,2;3,4:5;10")
        TextCalculator(io, Parser()).execute()

        assertThat(io.toString()).isEqualTo("25")
    }

    @Test
    fun `calculate() 문자열을 분리하여 합계 계산`() {

        assertThat(
            TextCalculator(MockUpIOManager(""), Parser())
                .calculate("1,2:3,4:5:10")
        ).isEqualTo(25)
    }

    @Test
    fun `calculate() 커스텀 구분자 있는 정상 케이스일 때 합계 계산`() {
        assertThat(
            TextCalculator(MockUpIOManager(""), Parser())
                .calculate("//;\\n1,2;3,4:5;10")
        ).isEqualTo(25)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "_", "aa", "1.0", "a11"])
    fun `calculate() 음수 또는 잘못된 문자열 있으면 RuntimeException`(text: String) {
        assertThatThrownBy {
            TextCalculator(MockUpIOManager(""), Parser())
                .calculate("1,2:3,4:5$text")
        }.isInstanceOf(RuntimeException::class.java)
    }
}
