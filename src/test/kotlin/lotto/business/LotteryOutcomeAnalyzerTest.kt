package lotto.business

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LotteryOutcomeAnalyzerTest {
    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6,SIX_MATCH", "1,2,3,4,5,7,FIVE_MATCH", "1,2,3,4,8,9,FOUR_MATCH", "1,2,3,7,8,9,THREE_MATCH", "1,2,7,8,9,10,NONE"])
    fun `당첨 번호와 티켓을 비교하여 당첨결과를 분석한다`(
        num1: Int,
        num2: Int,
        num3: Int,
        num4: Int,
        num5: Int,
        num6: Int,
        expected: LotteryPrize
    ) {
        // given
        val lottoWinningNumbers = LottoWinningNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
        )
        val lottoTicket = LottoTicket(
            listOf(
                LottoNumber(num1),
                LottoNumber(num2),
                LottoNumber(num3),
                LottoNumber(num4),
                LottoNumber(num5),
                LottoNumber(num6)
            )
        )
        val lotteryOutcomeAnalyzer = LotteryOutcomeAnalyzer()

        // when
        val result = lotteryOutcomeAnalyzer.analyze(lottoWinningNumbers, lottoTicket)

        // then
        assertThat(result).isEqualTo(expected)
    }
}
