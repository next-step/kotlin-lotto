package lotto.presentation.controller

import lotto.domain.LottoStore.Companion.LOTTO_PRICE
import lotto.domain.Rank
import lotto.domain.vo.Amount
import lotto.domain.vo.RankFrequency

// TODO-review : LottoResult 는 view <-> domain 사이의 결합을 낮추기 위해 controller 에서 사용하는 객체입니다.
// 이러한 객체들은 패키지 구조상 어디에 위치해야하는지 고민입니다!
class LottoResult(
    private val rankCounts: Map<Rank, RankFrequency>,
) {
    fun getEarningRate(): Double {
        val totalPrize = rankCounts
            .map { (rank, rankFreq) -> rank.winningMoney * rankFreq.value }
            .sum()
            .let { Amount.of(it.value) }

        val totalTicketPrice = rankCounts.values
            .sum()
            .let { Amount.of(it.value * LOTTO_PRICE) }

        return (totalPrize / totalTicketPrice).toDouble()
    }

    fun getResultTable(): List<List<Int>> {
        /**
         * 3개 일치 (5000원)- 1개
         * 4개 일치 (50000원)- 0개
         * 5개 일치 (1500000원)- 0개
         * 5개 일치, 보너스 볼 일치(30000000원) - 0개
         * 6개 일치 (2000000000원)- 0개
         * */
        val result = Rank.values().map { rank ->
            val rankFrequency = rankCounts[rank] ?: RankFrequency.of(0)
            val matchedCount = rank.countOfMatch
            val winningMoney = rank.winningMoney
            val frequency = rankFrequency.value

            listOf(matchedCount.value, winningMoney.value, frequency)
        }

        return result
    }

    // TODO-review : 값 객체를 사용하면서 필요한 기능을 확장 함수로 구현했는데요. 사용이 적절한가요?
    //  해당 클래스에서만 사용되어서 가독성이 떨어지지 않을지, 더 좋은 방법은 없을지 고민입니다!
    private fun Iterable<Amount>.sum() = Amount.of(sumOf { it.value })
    private fun Iterable<RankFrequency>.sum() = RankFrequency.of(sumOf { it.value })
}
