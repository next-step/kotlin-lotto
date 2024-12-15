package lotto.view

import lotto.domain.BonusMatchResult
import lotto.domain.LottoBunch
import lotto.domain.MatchingResult

class ResultView {
    fun showPurchaseCount(purchaseCount: Int) {
        println("${purchaseCount}개를 구매했습니다.")
    }

    fun showPurchaseLotto(lottoBunch: LottoBunch) {
        lottoBunch.value.forEach {
            println(it.lottoNumbers.map { it.value }.toString())
        }
    }

    fun showResultInterface() {
        println("당첨 통계")
        println("----------")
    }

    fun showMatchLottoResult(result: Map<MatchingResult, Int>) {
        result.forEach { key, value ->
            val bonusResultMessage =
                when (key.bonusMatchResult) {
                    BonusMatchResult.MATCH -> ", 보너스 볼 일치"
                    BonusMatchResult.NOT_MATCH, BonusMatchResult.NO_EFFECT -> ""
                }
            println("${key.matchNumber}개 일치$bonusResultMessage (${key.prizeAmount}원)- ${value}개")
        }
    }

    fun showYield(yield: Double) {
        println("총 수익률은 ${String.format("%.2f", yield)}입니다.")
    }
}
