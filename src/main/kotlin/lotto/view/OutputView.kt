package lotto.view

import lotto.domain.LottoMachineResult
import lotto.domain.LottoRank
import lotto.domain.LottoTicket
import lotto.supportdata.PurchaseInfo

object OutputView {

    fun printPurchasingLottoNumber(lottoTickets: List<LottoTicket>) {
        println("${lottoTickets.size}개를 구매했습니다.")
        lottoTickets.forEach { println(it) }
        println()
    }

    fun printWinnerStatistics(lottoMachineResult: LottoMachineResult, purchaseInfo: PurchaseInfo) {
        println()
        println("당첨통계")
        println("---------")
        LottoRank.values()
            .filter { it != LottoRank.OUT }
            .forEach { println("${it.rankInfoString()} - ${lottoMachineResult.getLottoRankCount(it)}개") }
        println("총 수익률은 ${lottoMachineResult.calculateProfit(purchaseInfo)}입니다.")
    }

    private fun LottoRank.rankInfoString(): String =
        if (this == LottoRank.BONUS) "${matchCount}개 일치, 보너스 볼 일치(${price}원)"
        else "${matchCount}개 일치 (${price}원)"
}
