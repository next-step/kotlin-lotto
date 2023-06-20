package com.nextstep.second.lotto.domain

class LottoResult private constructor(
    private val matchedNumberCounts: Map<LottoReward, Int>
) {
    fun getMatchedNumberCount(score: LottoReward): Int {
        return matchedNumberCounts.getOrDefault(score, 0)
    }

    fun getRateOfReturn(money: Int): Double {
        return matchedNumberCounts.entries.sumOf { (reward, totalCount) ->
            reward.calculateTotalReward(totalCount)
        } / money.toDouble()
    }

    companion object {
        fun of(
            winnerLotto: WinnerLotto,
            lottos: List<Lotto>,
        ): LottoResult {
            val matchedNumberCounts = mutableMapOf<LottoReward, Int>()
            lottos.map { lotto ->
                val cnt = winnerLotto.countSameNumbers(lotto)
                val matchedBonus = winnerLotto.checkBonusNumber(lotto)
                val lottoReward = LottoReward.valueOf(cnt, matchedBonus)
                matchedNumberCounts.put(lottoReward, matchedNumberCounts.getOrDefault(lottoReward, 0) + 1)
            }
            return LottoResult(matchedNumberCounts)
        }
    }
}
