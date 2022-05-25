package lotto.domain

import lotto.model.LottoResult

/**
 * 수익률을 계산하는 클래스
 * Created by Jaesungchi on 2022.05.25..
 */
object YieldCalculator {
    fun calculateYield(money: Int, results: List<LottoResult>): Double {
        val priceMoney = results.sumOf { it.count * it.prize.reward }
        return priceMoney.toDouble() / money.toDouble()
    }
}
