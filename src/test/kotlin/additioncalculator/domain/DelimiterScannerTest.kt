package additioncalculator.domain

import additioncalculator.domain.DelimiterScanner.DELIMITER_TEXT_NOT_EMPTY_MESSAGE
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EmptySource
import java.lang.IllegalArgumentException

class DelimiterScannerTest {
    @Test
    fun `구분자를 찾으려는 문자열이 빈 값일 경우 에러가 발생한다`() {
        shouldThrowWithMessage<IllegalArgumentException>(message = DELIMITER_TEXT_NOT_EMPTY_MESSAGE) {
            DelimiterScanner.findDelimiters(inputText = "")
        }
    }
    @Test
    fun `기본 구분자 쉼표(,)를 찾아낼 수 있다`() {
        val findDelimiters = DelimiterScanner.findDelimiters(inputText = "1,2,3,4,5")
        findDelimiters.containsAll(listOf(",")) shouldBe true
    }

    @Test
    fun `보조 구분자 colon을 찾아낼 수 있다`() {
        val findDelimiters = DelimiterScanner.findDelimiters(inputText = "1:2:3:4:5")
        findDelimiters.containsAll(listOf(":")) shouldBe true
    }

    @Test
    fun `커스텀 구분자를 찾아낼 수 있다`() {
        val findDelimiters = DelimiterScanner.findDelimiters(inputText = "//t\n" + "1t2t3t4")
        findDelimiters.containsAll(listOf("t")) shouldBe true
    }

    @Test
    fun `기본 구분자를 포함하여 문자열을 토대로 모든 구분자를 찾아낼 수 있다`() {
        val findDelimiters = DelimiterScanner.findDelimiters(inputText = "//t\n" + "1t2,3:4")
        findDelimiters.containsAll(listOf(",", ":", "t")) shouldBe true
    }
}
