package lotto.views

import lotto.domain.Budget
import lotto.domain.LottoResult
import lotto.domain.Lottos
import lotto.domain.Reward
import java.util.Collections

import java.util.TreeMap

object OutputView {

    fun showInputResult(lottos: Lottos, budget: Budget) {
        val lottoCount = budget.getLottoCount()
        val inputInformation = buildString {
            append(lottoCount).append(LOTTO_COUNT_INFORMATION)
            append(System.lineSeparator())
            lottos.lottos.forEach { lotto ->
                append(lotto)
                append(System.lineSeparator())
            }
        }
        println(inputInformation)
    }

    fun showResult(lottoResult: LottoResult, budget: Budget) {
        println(GAME_RESULT)
        println(DASH)

        showRewards(lottoResult)
        println("$TOTAL_PROFIT ${lottoResult.getProfit(budget)}입니다.")
    }

    private fun showRewards(lottoResult: LottoResult) {
        val treeMapReverse = TreeMap<Reward, Int>(Collections.reverseOrder())
        treeMapReverse.putAll(lottoResult.result)
        treeMapReverse.forEach { (key, value) ->
            if (key == Reward.NONE) {
                return@forEach
            }
            println("${key.matchCount} $LOTTO_MATCHED (${key.amount})$MONEY_UNIT - ${value}$LOTTO_COUNT")
        }
    }

    private const val LOTTO_COUNT_INFORMATION = "개를 구매했습니다"
    private const val GAME_RESULT = "당첨 통계"
    private const val DASH = "---------"
    private const val MONEY_UNIT = "원"
    private const val LOTTO_COUNT = "개"
    private const val TOTAL_PROFIT = "총 수익률은"
    private const val LOTTO_MATCHED = "개 일치"
}
