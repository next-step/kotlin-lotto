package com.nextstep.second.lotto.domain

class LottoResult private constructor(
    private val matchedNumberCounts: Map<LottoReward, Int>
) {

    fun getMatchedNumber(score: Int, matchedBonus: Boolean = false): Int {
        val lottoReward = LottoReward.valueOf(score, matchedBonus)
        return matchedNumberCounts.getOrDefault(lottoReward, 0)
    }

    fun getMatchedNumber(score: LottoReward): Int {
        return matchedNumberCounts.getOrDefault(score, 0)
    }

    fun getRateOfReturn(money: Int): Double {
        return matchedNumberCounts.entries.filter { (reward, totalCount) ->
            totalCount != 0
        }.sumOf { (reward, totalCount) ->
            reward.reward * totalCount
        } / money.toDouble()
    }

    companion object {
        fun of(
            winnerLotto: WinnerLotto,
            lottos: List<Lotto>,
        ): LottoResult {
            val matchedNumberCounts = mutableMapOf<LottoReward, Int>()
            lottos.map { lotto ->
                val cnt = compareLottoResult(winnerLotto, lotto)
                val matchedBonus = checkBonusNumber(winnerLotto, lotto)
                val lottoReward = LottoReward.valueOf(cnt, matchedBonus)
                matchedNumberCounts.put(lottoReward, matchedNumberCounts.getOrDefault(lottoReward, 0) + 1)
            }
            return LottoResult(matchedNumberCounts)
        }

        private fun compareLottoResult(a: WinnerLotto, b: Lotto): Int {
            return a.numbers.intersect(b.numbers.toSet()).size
        }

        private fun checkBonusNumber(winnerLotto: WinnerLotto, lotto: Lotto): Boolean {
            return lotto.contains(winnerLotto.bonusNumber)
        }
    }
}
