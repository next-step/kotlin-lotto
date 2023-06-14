package calculator

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import org.junit.jupiter.params.provider.ArgumentsSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.stream.Stream

class StringAddCalculatorTest {
    private lateinit var calculator: StringAddCalculator

    @BeforeEach
    fun setUp() {
        calculator = StringAddCalculator()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1,2:3"])
    fun `쉼표 또는 콜론을 구분자로 가지는 문자열을 전달 받아 구분자를 기준으로 분리 후 반환한다`(input: String) {
        val actual = calculator.split(input)
        actual shouldBe listOf("1", "2", "3")
    }

    @ParameterizedTest
    @ArgumentsSource(StringListArgumentsProvider::class)
    fun `전달 받은 문자열을 구분자를 기준으로 분리 후 각 숫자의 합을 구한다`(input: List<String>) {
        val actual = calculator.stringAdd(input)
        actual shouldBe 6
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
