package lotto.domain

/**
 * 수익률을 계산하는 클래스
 * Created by Jaesungchi on 2022.05.25..
 */
object YieldCalculator {
    fun calculateYield(money: Int, lottoResults: LottoResults): Double {
        return lottoResults.getReward().toDouble() / money.toDouble()
    }
}
