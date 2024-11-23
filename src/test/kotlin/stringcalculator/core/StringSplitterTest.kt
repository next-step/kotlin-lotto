package stringcalculator.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class StringSplitterTest {
    @ParameterizedTest
    @CsvSource(
        "'', 1",
        "'0', 1",
        "'1', 1",
        "'1,2', 2",
        "'1;2', 2",
        "'1;2,3', 3",
    )
    fun `기분 구분자의 문자열 분할 기능을 확인한다`(
        token: String,
        result: Int,
    ) {
        StringSplitter(token).split().size shouldBe result
    }

    @ParameterizedTest
    @CsvSource(
        "'1a2a3', 'a' , 3",
        "'1a2', 'a' , 2",
        "'1,3', 'a' , 2",
        "'1;4', 'a' , 2",
        "'1;5', 'a' , 2",
        "'1a2,3;4', 'a' , 4",
    )
    fun `커스텀 구분자의 문자열 분할 기능을 확인한다`(
        token: String,
        customDelimiter: String,
        result: Int,
    ) {
        StringSplitter(token, customDelimiter).split().size shouldBe result
    }
}
