package view

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

internal class BonusNumberParserTest {
    @Test
    fun `숫자가 아니라면 null을 반환`() {
        // given
        val input = "a"
        val winningNumbers = ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual = BonusNumberParser.parse(input, winningNumbers)

        // then
        assertThat(actual).isNull()
    }

    @ParameterizedTest
    @ValueSource(strings = ["0", "-1", "46"])
    fun `1부터 45 사이 숫자가 아니라면 null을 반환`(input: String) {
        // given
        val winningNumbers = ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual = BonusNumberParser.parse(input, winningNumbers)

        // then
        assertThat(actual).isNull()
    }

    @ParameterizedTest
    @ValueSource(strings = ["1", "2", "3", "4", "5", "6"])
    fun `숫자가 당첨번호에 포함되어 있다면 null을 반환`(input: String) {
        // given
        val winningNumbers = ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual = BonusNumberParser.parse(input, winningNumbers)

        // then
        assertThat(actual).isNull()
    }

    @ParameterizedTest(name = "1,2,3,4,5,6에 포함되지 않은 {0}은 {1}을 반환한다")
    @CsvSource(
        "'7', 7",
        "'11', 11",
        "'45', 45"
    )
    fun `숫자가 당첨번호에 포함되지 않은 1부터 45사이의 숫자면 해당 값을 반환`(input: String, expected: Int) {
        // given
        val exceptNumbers = ParsedLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual = BonusNumberParser.parse(input, exceptNumbers)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}
