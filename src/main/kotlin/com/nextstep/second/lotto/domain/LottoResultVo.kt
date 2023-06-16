package com.nextstep.second.lotto.domain

class LottoResultVo(
    winnerLottoNumber: Lotto,
    lottoNumbers: List<Lotto>
) {
    val matchedNumberCounts: Map<Int, Int>

    init {
        matchedNumberCounts = mutableMapOf()
        lottoNumbers.map { lotto ->
            val cnt = winnerLottoNumber.numbers.intersect(lotto.numbers.toSet()).size
            matchedNumberCounts.put(cnt, matchedNumberCounts.getOrDefault(cnt, 0) + 1)
        }
    }

    fun getMatchedNumber(score: Int): Int {
        return matchedNumberCounts.getOrDefault(score, 0)
    }

    fun getRateOfReturn(money: Int, LottoRewards: List<LottoReward>): Double {
        return LottoRewards.sumOf {
            getMatchedNumber(it.totalSameNumber).toLong() * it.reward.toLong()
        }.toDouble() / money.toDouble()
    }
}
