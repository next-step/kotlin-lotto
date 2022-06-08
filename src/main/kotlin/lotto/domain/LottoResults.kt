package lotto.domain

/**
 * 로또 결과를 담고 있는 일급 컬렉션.
 * Created by Jaesungchi on 2022.05.30..
 */
class LottoResults(val results: List<Prize>) {
    fun getReward(): Int {
        return results.sumOf { it.reward }
    }

    fun getPrizeCount(prize: Prize): Int {
        return results.count { it == prize }
    }
}
