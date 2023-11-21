package lotto.domain

import lotto.data.LottoRanking
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoCalculatorTest {
    @Test
    fun `로또 수익율 반환 로직`() {
        // given : 구매한 로또의 통계와 구매 금액을 받는다.
        // 총 당첨금 5천원
        val cash = 100000
        val winningStatus = mutableMapOf<LottoRanking, Int>()
        winningStatus[LottoRanking.FifthPlace] = 1

        // when : 구매 금액 대비 당첨 금액에 대한 수익률은 요청한다.
        val actual: Float = LottoCalculator.calculateWinningRate(cash, winningStatus)

        // then : 수익률이 반환된다.
        assertThat(actual).isEqualTo(0.05f)
    }
}
