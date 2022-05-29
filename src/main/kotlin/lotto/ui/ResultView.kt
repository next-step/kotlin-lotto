package lotto.ui

import lotto.application.dto.LottoResult
import lotto.application.vo.Purchase
import lotto.domain.Lotto
import lotto.domain.LottoBundle
import lotto.domain.MatchType

object ResultView {
    fun printLottoBundle(lottoBundle: LottoBundle) {
        lottoBundle.lottos.forEach { printLotto(it) }
    }

    private fun printLotto(lotto: Lotto) {
        println(lotto.lottoNumbers)
    }

    fun printLottoCount(purchase: Purchase) {
        println("수동으로 ${purchase.purchaseCounts.manualLottoCount.count}장, " +
            "자동으로 ${purchase.purchaseCounts.autoLottoCount.count}개를 구매했습니다.")
    }

    fun printWinningResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("--------")
        MatchType.values()
            .filter { it.matchCount > 0 }
            .forEach { printWinningResult(it, lottoResult) }
        println("총 수익률은 ${lottoResult.winningRate}입니다.")
    }

    private fun printWinningResult(it: MatchType, lottoResult: LottoResult) {
        if (it == MatchType.FIVE_AND_BONUS_MATCH)
            println("${it.matchCount}개 일치, 보너스 볼 일치 (${it.amount.value}원)- ${lottoResult.winningResults[it] ?: 0}개")
        else println("${it.matchCount}개 일치 (${it.amount.value}원)- ${lottoResult.winningResults[it] ?: 0}개")
    }
}
