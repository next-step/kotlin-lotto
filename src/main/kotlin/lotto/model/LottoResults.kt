package lotto.model

/**
 * 로또 결과를 담고 있는 일급 컬렉션.
 * Created by Jaesungchi on 2022.05.30..
 */
class LottoResults(val results: List<LottoResult>) {
    fun getReward(): Int {
        return results.sumOf { it.count * it.prize.reward }
    }

    fun getPrizeCount(prize: Prize): Int {
        return results.find { it.prize == prize }?.count ?: NOT_HAVE_TICKET_COUNT
    }

    companion object {
        private const val NOT_HAVE_TICKET_COUNT = 0
    }
}
