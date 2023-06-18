package com.nextstep.second.lotto.domain

class LottoResult(
    winningLotto: Lotto,
    lottos: List<Lotto>
) {
    private val matchedNumberCounts: Map<Int, Int>

    init {
        matchedNumberCounts = mutableMapOf()
        lottos.map { lotto ->
            val cnt = winningLotto.numbers.intersect(lotto.numbers.toSet()).size
            matchedNumberCounts.put(cnt, matchedNumberCounts.getOrDefault(cnt, 0) + 1)
        }
    }

    fun getMatchedNumber(score: Int): Int {
        return matchedNumberCounts.getOrDefault(score, 0)
    }

    fun getRateOfReturn(money: Int, lottoRewards: List<LottoReward>): Double {
        return lottoRewards.sumOf {
            getMatchedNumber(it.totalSameNumber).toLong() * it.reward.toLong()
        }.toDouble() / money.toDouble()
    }
}
