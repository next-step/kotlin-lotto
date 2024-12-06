package calculator.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class InputTokenizerTest {
    @ParameterizedTest
    @ValueSource(
        strings = [
            "1;2;3",
            "1,2,3",
        ],
    )
    fun `문자열 입력 테스트-기본 구분자 사용`(input: String) {
        val tokenizer = InputTokenizer(input)
        tokenizer.getDelimiter() shouldBe ",|:"
    }

    @Test
    fun `커스텀 구분자 테스트`() {
        val tokenizer = InputTokenizer("//;\n1;2;3")
        tokenizer.getDelimiter() shouldBe ";"
        tokenizer.getTokensIterator().next() shouldBe "1"
    }

    @ParameterizedTest
    @CsvSource(
        "'//-\n1-2-3', '-'",
        "'//a\n1a2a3', 'a'",
        "'//^\n1^2^3', '^'",
    )
    fun `문자열 입력 테스트-커스텀 구분자 사용`(
        input: String,
        delimiter: String,
    ) {
        val tokenizer = InputTokenizer(input)
        tokenizer.getDelimiter() shouldBe delimiter
    }

    @ParameterizedTest
    @CsvSource(
        "'//;\n1;2;3', 1",
        "'//a\n11a2a3', 11",
        "'//^\n15^2^3', 15",
    )
    fun `문자열 입력 첫번째 숫자 확인`(
        input: String,
        number: Int,
    ) {
        val tokenizer = InputTokenizer(input)
        tokenizer.getTokensIterator().next().toInt() shouldBe number
    }
}
