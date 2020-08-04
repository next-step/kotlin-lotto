package lotto.domain

object EarnRatio {

    fun calculate(useMoney: Int, lottoResults: List<LottoResult>): Double {
        return lottoResults.totalPrizeMoney() / useMoney.toDouble()
    }

    private fun List<LottoResult>.totalPrizeMoney(): Long {
        return this.map { it.prize }.sum()
    }
}
