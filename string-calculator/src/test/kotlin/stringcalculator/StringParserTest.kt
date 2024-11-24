package stringcalculator

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.string.shouldContain
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import stringcalculator.StringParser.splitToInts
import stringcalculator.StringParser.toCalculateRequest

class StringParserTest {
    @Test
    fun `입력값은 줄바꿈 문자를 기준으로 나뉜다`() {
        val input = "//;\\n1;2;3"
        val delimiters = listOf(":", ",", ";")

        val (delimiter, payload) = input.toCalculateRequest()

        delimiter.regex shouldBe Regex(delimiters.joinToString("|"))
        payload shouldBe "1;2;3"
    }

    @Test
    fun `커스텀 구분자가 없는 경우 기본값으로 구분된다`() {
        val input = "1:2:3"
        val delimiters = listOf(":", ",")

        val (delimiter, payload) = input.toCalculateRequest()

        delimiter.regex shouldBe Regex(delimiters.joinToString("|"))
        payload shouldBe input
    }

    @Test
    fun `커스텀 구분자를 사용해도 기본 구분자를 사용할 수 있다`() {
        val input = "//;\\n1:2;3,4"

        val (delimiter, payload) = input.toCalculateRequest()
        val numbers = payload.splitToInts(delimiter)

        numbers.sum() shouldBe 10
    }

    @Test
    fun `커스텀 구분자의 시작이 규칙에 어긋나는 경우 사용할 수 없다`() {
        val input = "!!;\\n1:2;3,4"
        val delimiters = listOf(":", ",")

        val (delimiter) = input.toCalculateRequest()

        delimiter.regex shouldBe Regex(delimiters.joinToString("|"))
    }

    @Test
    fun `음수가 들어가는 경우 실패한다`() {
        val input = "-3"

        val (delimiter, payload) = input.toCalculateRequest()

        val exception = shouldThrowExactly<RuntimeException> {
            payload.splitToInts(delimiter)
        }

        exception.message shouldContain "값이 음수거나 Int로 변환하는데 실패했습니다"
    }

    @Test
    fun `Int로 변환할 수 없는 경우 실패한다`() {
        val input = "1:2:a"

        val (delimiter, payload) = input.toCalculateRequest()

        val exception = shouldThrowExactly<RuntimeException> {
            payload.splitToInts(delimiter)
        }

        exception.message shouldContain "값이 음수거나 Int로 변환하는데 실패했습니다"
    }

    @ParameterizedTest
    @NullAndEmptySource
    fun `빈 문자열 또는 null 값을 입력할 경우 0을 반환해야 한다`(input: String?) {
        val (delimiter, payload) = input.toCalculateRequest()
        val numbers = payload.splitToInts(delimiter)

        numbers.sum() shouldBe 0
    }
}
