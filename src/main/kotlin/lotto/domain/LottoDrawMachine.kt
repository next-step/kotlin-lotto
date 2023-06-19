package lotto.domain

class LottoDrawMachine(val winningNumbers: WinningNumbers) {

    fun draw(lottos: List<Lotto>): LottoDrawResult {
        val lottoRanks: List<LottoRank> = lottos.mapNotNull {
            val matchingCount = winningNumbers.countMatchingNumbers(it)
            LottoRank.valueOf(matchingCount)
        }
        return LottoDrawResult(lottos.size, lottoRanks)
    }
}

class LottoDrawResult(val countOfLottos: Int, val lottoRanks: List<LottoRank>) {
    fun countOf(lottoRank: LottoRank): Int {
        return lottoRanks.count { it == lottoRank }
    }

    fun totalReward(): Int {
        return lottoRanks.sumOf { it.reward }
    }

    fun profitability(): Double {
        val totalPurchaseAmount = countOfLottos * LottoStore.LOTTO_PRICE
        return (totalReward() / totalPurchaseAmount).toDouble()
    }
}
