package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class WinningLottoTicketExtractorTest {
    @Test
    fun `입력한 당첨 결과를 파싱한다`() {
        // given
        val input = "1,2,3,4,5,6"
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()

        // when
        val lottoWinningNumbers = LottoWinningTicketExtractor.extract(input)

        // then
        assertThat(lottoWinningNumbers.sortedLottoNumbers).usingRecursiveComparison().isEqualTo(expectedLottoNumbers)
    }

    @Test
    fun `입력한 당첨 결과가 숫자가 아니면 예외를 던진다`() {
        // given
        val input = "1,2,3,4,5,6a"

        // when, then
        assertThatThrownBy { LottoWinningTicketExtractor.extract(input) }
            .isInstanceOf(IllegalArgumentException::class.java)
            .message().isEqualTo("당첨 번호는 숫자여야 합니다.")
    }

    @ParameterizedTest
    @CsvSource(
        value = ["1,2,3,4,5,6:6", "1,2,3,4,5,7:5", "1,2,3,4,7,8:4", "1,2,3,7,8,9:3", "1,2,7,8,9,10:2", "1,7,8,9,10,11:1", "7,8,9,10,11,12:0"],
        delimiter = ':'
    )
    fun `로또번호 리스트를 비교하여 일치하는 갯수를 반환한다`(input: String, expected: Int) {
        // given
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val lottoTicket = LottoTicket(lottoNumber)
        val targetLottoNumbers = input.split(",").map { LottoNumber(it.toInt()) }

        // when
        val matchCount = lottoTicket.matchCount(targetLottoNumbers)

        // then
        assertThat(matchCount).isEqualTo(expected)
    }
}
