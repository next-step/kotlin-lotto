package lotto.domain

import lotto.supportdata.PurchaseInfo
import lotto.supportdata.WinNumber
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.DisplayName

internal class LottoMachineResultTest {

    @Test
    @DisplayName("원하는 순위의 당첨 결과의 개수를 확인할 수 있다")
    fun getLottoRankCount() {
        // give
        val winNumber = WinNumber("1,2,3,4,10,11")
        val userTicket1 = LottoTicket.of(listOf(1, 2, 3, 4, 5, 6)) // 4개
        val userTicket2 = LottoTicket.of(listOf(1, 2, 3, 4, 10, 11)) // 6개
        val userTicket3 = LottoTicket.of(listOf(3, 4, 10, 11, 12, 13)) // 4개
        // when
        val lottoMachineResult = LottoMachineResult(listOf(userTicket1, userTicket2, userTicket3), winNumber)
        // then
        assertThat(lottoMachineResult.getLottoRankCount(LottoRank.FIRST)).isEqualTo(1)
        assertThat(lottoMachineResult.getLottoRankCount(LottoRank.SECOND)).isEqualTo(0)
        assertThat(lottoMachineResult.getLottoRankCount(LottoRank.THIRD)).isEqualTo(2)
        assertThat(lottoMachineResult.getLottoRankCount(LottoRank.FOURTH)).isEqualTo(0)
    }

    @Test
    @DisplayName("구매가격과 로또 당첨금을 기반으로한 수익률을 계산한다.")
    fun getYield() {
        // give
        val winNumber = WinNumber("1,2,3,4,10,11")
        val fourth = LottoTicket.of(listOf(1, 2, 3, 20, 21, 22)) // 3개
        val lottoMachineResult = LottoMachineResult(listOf(fourth), winNumber)
        val purchaseInfo = PurchaseInfo(14000)
        // when
        val calculateYield = lottoMachineResult.calculateProfit(purchaseInfo) // 구매가격 : 14000원 / 로또 당첨금 4등 = 5000원
        // then
        assertThat(lottoMachineResult.getLottoRankCount(LottoRank.FOURTH)).isEqualTo(1)
        assertThat(calculateYield).isEqualTo(0.36)
    }
}
