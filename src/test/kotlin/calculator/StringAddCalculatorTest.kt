package calculator

import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThatExceptionOfType
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import org.junit.jupiter.params.provider.ValueSource

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator();
    }
    @ParameterizedTest
    @NullAndEmptySource
    fun `null 혹은 빈값 인 경우 을 반환`(input:String) {
        val result = calculator.add(input)
        result shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["1"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input:String) {
        val result = calculator.add(input)
        result shouldBe input.toInt()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2"])
    fun `숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다`(input:String) {
        val result = calculator.add(input)
        result shouldBe 3
    }
    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `구분자를 컴마(,) 이외에 콜론을 사용할 수 있다`(input:String) {
        val result = calculator.add(input)
        result shouldBe 6
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2;3"])
    fun `위 valueSource의 커스텀 구분자를 지정할 수 있다`(input:String) {
        val result = calculator.add(input)
        result shouldBe 6
    }

    @Test
    fun `음수를 전달할 경우 RuntimeException 예외가 발생해야 한다`() {
        assertThatExceptionOfType(RuntimeException::class.java).isThrownBy {
            calculator.add("-1")
        }
    }

}