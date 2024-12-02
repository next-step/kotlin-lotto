package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private var calculator: StringAddCalculator = StringAddCalculator()

    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        val result = calculator.add(input)
        result shouldBe input.toInt()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(input: String) {
        val result = calculator.add(input)
        result shouldBe 3
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 컴마(,) 이외에 콜론을 사용할 수 있다`(input: String) {
        val result = calculator.add(input)
        result shouldBe 6
    }

    @Test
    fun `음수를 전달할 경우 RuntimeException 예외가 발생해야 한다`() {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            calculator.add("-1")
//            exception을 검사할 때 type만 검사하게되면 올바르게 검사가 되었다고 볼 수 있을까요?
//
//            거짓양성, 거짓음성에 대해 알아보시면 좋을것 같습니다.
        }
    }
}
