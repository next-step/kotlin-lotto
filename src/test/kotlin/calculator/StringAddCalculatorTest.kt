package calculator

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 전달 받아 구분자를 기준으로 분리 후 반환한다`(input: String) {
        calculator = StringAddCalculator(input = input)
        val actual = calculator.splitByDelimiter(fixedDelimiter = null, input = input)
        actual shouldBe listOf("1", "2", "3")
    }

    @ParameterizedTest
    @ArgumentsSource(StringListArgumentsProvider::class)
    fun `분리 된 리스트의 각 숫자의 합을 구한다`(input: List<String>) {
        calculator = StringAddCalculator(input = "1,2,3")
        val actual = calculator.stringAdd(input)
        actual shouldBe 6
    }

    @ParameterizedTest
    @ValueSource(strings = [""])
    fun `빈 문자열 또는 null 을 입력할 경우 0을 반환 한다`(input: String?) {
        calculator = StringAddCalculator(input = input)
        val actualEmpty = calculator.calculate()
        actualEmpty shouldBe 0

        val actualNull = calculator.calculate()
        actualNull shouldBe 0
    }

    @ParameterizedTest
    @ValueSource(strings = ["3"])
    fun `숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다`(input: String) {
        calculator = StringAddCalculator(input = input)
        val actual = calculator.calculate()
        actual shouldBe 3
    }

    @ParameterizedTest
    @ValueSource(strings = ["-3"])
    fun `음수 하나만을 전달할 경우 RuntimeException 예외가 발생한다`(input: String) {
        shouldThrow<RuntimeException> {
            calculator = StringAddCalculator(input = input)
            calculator.calculate()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,-2:3"])
    fun `전달할 문자열 내 음수가 포함되어 있는 경우 RuntimeException 예외가 발생한다`(input: String) {
        shouldThrow<RuntimeException> {
            calculator = StringAddCalculator(input = input)
            calculator.calculate()
        }
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n1;2:3"])
    @DisplayName("문자열 앞부분의 \"//\"와 \"\\n\" 사이에 위치하는 문자를 커스텀 구분자 구한다")
    fun `getCustomDelimiter`(input: String) {
        calculator = StringAddCalculator(input = input)
        val actual = calculator.getCustomDelimiter(input)
        actual shouldBe ";"
    }

    @ParameterizedTest
    @ValueSource(strings = ["//;\n7;2:1"])
    fun `커스텀 구분자가 있을 시 동일하게 구분자로서의 숫자 분리 후 합을 반환한다`(input: String) {
        calculator = StringAddCalculator(input = input)
        val actual = calculator.calculate()
        actual shouldBe 10
    }

    companion object {
        object StringListArgumentsProvider : ArgumentsProvider {
            override fun provideArguments(context: ExtensionContext): Stream<out Arguments> {
                return Stream.of(
                    Arguments.of(listOf("1", "2", "3"))
                )
            }
        }
    }
}
