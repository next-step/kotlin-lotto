package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTicketExtractorTest {
    @Test
    fun `입력한 당첨 결과를 파싱한다`() {
        // given
        val input = "1,2,3,4,5,6"
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()

        // when
        val lottoWinningNumbers = LottoTicketExtractor.extractLottoTicket(input)

        // then
        assertThat(lottoWinningNumbers.lottoNumbers).usingRecursiveComparison()
            .isEqualTo(expectedLottoNumbers)
    }

    @Test
    fun `입력한 수동 티켓을 파싱한다`() {
        // given
        val input = listOf("1,2,3,4,5,6", "1,2,3,4,5,7")
        val expectedLottoNumbers = listOf(
            LottoTicket(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()),
            LottoTicket(listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }.toSet())
        )

        // when
        val lottoWinningNumbers = LottoTicketExtractor.extractManualTicketNumbers(input)

        // then
        assertThat(lottoWinningNumbers).usingRecursiveComparison()
            .isEqualTo(expectedLottoNumbers)
    }
}
