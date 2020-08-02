package stringCalculator

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import stringCalculator.domain.StringCalculator
import stringCalculator.strategy.CustomRegexParserStrategy
import stringCalculator.strategy.NormalParserStrategy
import stringCalculator.view.InputView

class StringCalculatorTest {

    @ParameterizedTest
    @ValueSource(strings = [" ", ""])
    fun `is inputCount empty`(inputText: String) {
        val userInputTemplate = InputView.checkUserInput(inputText)
        assertThat(userInputTemplate).isEqualTo("0")
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "3"])
    fun `only digit parameter`(inputText: String) {
        val result = StringCalculator.doSplit(inputText)
        assertThat(inputText.toInt()).isEqualTo(result)
    }

    @ParameterizedTest
    @ValueSource(strings = ["//?\\n1?2?3", "//;\\n1;2;3"])
    fun `custom regex parameter`(inputText: String) {
        val result = CustomRegexParserStrategy().parsingNumber(inputText)
        assertThat(result).isEqualTo(listOf(1, 2, 3))
    }

    @ParameterizedTest
    @ValueSource(strings = ["1;2;5", "1,2,5"])
    fun `normal parameter`(inputText: String) {
        val result = NormalParserStrategy().parsingNumber(inputText)
        assertThat(result).isEqualTo(listOf(1, 2, 5))
    }

    // require()결과로 나오는 값의 테스트를 어떻게하느지 모르겠다
    // @ParameterizedTest
    // @ValueSource(strings = ["-3", "-1"])
    // fun `negative number check`(inputText: String) {
    //     assertThatExceptionOfType(RuntimeException::class.java)
    //         .isThrownBy { StringCalculator.getOnlyNumberAddResult(inputText) }
    // }

    @ParameterizedTest
    @ValueSource(strings = ["1;2;5", "1,2,5", "//?\\n1?2?5"])
    fun `add result`(inputText: String) {
        val addResult = StringCalculator.doSplit(inputText)
        assertThat(addResult).isSameAs(8)
    }
}
