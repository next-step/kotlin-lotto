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
        println("${purchase.lottoPurchaseCount}개를 구매했습니다.")
    }

    fun printWinningResult(lottoResult: LottoResult) {
        println("당첨 통계")
        println("--------")
        MatchType.values()
            .filter { it.matchCount > 0 }
            .forEach { println("${it.matchCount}개 일치 (${it.amount.value}원)- ${lottoResult.winningResults[it] ?: 0}개") }

        println("총 수익률은 ${lottoResult.winningRate}입니다.")
    }
}
