package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.EmptySource
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberParserTest {
    @ParameterizedTest
    @EmptySource
    fun `빈 문자열일 경우 유효하지않은결과를 반환`(input: String) {
        // given
        val expected = InvalidManualNumbers("빈 문자열입니다. 다시 입력해 주세요.")

        // when
        val actual = LottoNumberParser.parse(input)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(
        strings = [
            "1,2,3,4,5",
            "1,2,삼,4,5,6"
        ]
    )
    fun `숫자 여섯자리가 아니라면 유효하지않은결과를 반환`(input: String) {
        // given
        val expected = InvalidManualNumbers("1부터 45 사이 숫자 여섯 개를 입력해 주세요.")

        // when
        val actual = LottoNumberParser.parse(input)

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "'1,2,3,4,5,6';1;2;3;4;5;6",
        "'40,41,42,43,44,45';40;41;42;43;44;45",
        delimiterString = ";"
    )
    fun `6개의 정수와 그 사이에 콤마가 있을 경우 로또숫자결과를 반환`(
        input: String,
        n1: Int,
        n2: Int,
        n3: Int,
        n4: Int,
        n5: Int,
        n6: Int
    ) {
        // given
        val expected = ParsedManualNumbers(listOf(n1, n2, n3, n4, n5, n6))

        val actual = LottoNumberParser.parse(input)
        // when

        // then
        assertThat(actual).isEqualTo(expected)
    }

    @ParameterizedTest
    @CsvSource(
        "'1, 2, 3, 4, 5, 6';1;2;3;4;5;6",
        delimiterString = ";"
    )
    fun `정수와 콤마 사이에 띄어쓰기가 있어도 정상적으로 로또숫자결과를 반환`(
        input: String,
        n1: Int,
        n2: Int,
        n3: Int,
        n4: Int,
        n5: Int,
        n6: Int
    ) {
        // given
        val expected = ParsedManualNumbers(listOf(n1, n2, n3, n4, n5, n6))

        val actual = LottoNumberParser.parse(input)
        // when

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
