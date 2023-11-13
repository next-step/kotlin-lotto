package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class WinningLottoTicketExtractorTest {
    @Test
    fun `입력한 당첨 결과를 파싱한다`() {
        // given
        val input = "1,2,3,4,5,6"
        val expectedLottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }.toSet()
        val bonusNumber = LottoNumber(7)

        // when
        val lottoWinningNumbers = LottoWinningTicketExtractor.extract(input, bonusNumber)

        // then
        assertThat(lottoWinningNumbers.winningLottoNumbers.lottoNumbers).usingRecursiveComparison()
            .isEqualTo(expectedLottoNumbers)
        assertThat(lottoWinningNumbers.bonusNumber).isEqualTo(bonusNumber)
    }
}
