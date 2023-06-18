package com.nextstep.second.lotto.domain

class LottoResult private constructor(
    private val matchedNumberCounts: Map<LottoReward, Int>
) {

    fun getMatchedNumber(score: Int): Int {
        val lottoReward = LottoReward.valueOf(score)
        return matchedNumberCounts.getOrDefault(lottoReward, 0)
    }

    fun getRateOfReturn(money: Int, lottoRewards: List<LottoReward>): Double {
        return lottoRewards.sumOf {
            getMatchedNumber(it.totalSameNumber).toLong() * it.reward.toLong()
        }.toDouble() / money.toDouble()
    }

    companion object {
        fun of(
            winningLotto: Lotto,
            lottos: List<Lotto>,
        ): LottoResult {
            val matchedNumberCounts = mutableMapOf<LottoReward, Int>()
            lottos.map { lotto ->
                val cnt = winningLotto.numbers.intersect(lotto.numbers.toSet()).size
                val lottoReward = LottoReward.valueOf(cnt)
                matchedNumberCounts.put(lottoReward, matchedNumberCounts.getOrDefault(lottoReward, 0) + 1)
            }
            return LottoResult(matchedNumberCounts)
        }
    }
}
