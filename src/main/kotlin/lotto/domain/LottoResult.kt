package lotto.domain

class LottoResult {
    private var lottoResults = mutableMapOf<LottoRanking, Int>()

    init {
        lottoResults = LottoRanking.values().associateWith { 0 } as MutableMap<LottoRanking, Int>
    }

    fun lottoRanking(purchaseLottoNumbers: List<LottoNumbers>, winningLotto: WinningLotto): Map<LottoRanking, Int> {
        for (purchaseLottoNumber in purchaseLottoNumbers) {
            addLottoRankingCount(
                LottoRanking.lottoRanking(
                    winningLotto.correctCount(purchaseLottoNumber),
                    winningLotto.matchedBonusBall(purchaseLottoNumber)
                )
            )
        }
        return this.lottoResults
    }

    fun rateOfReturn(inputMoney: Int): Float {
        var sum: Long = 0
        for (lottoRanking in lottoResults.keys) {
            val lottoResult: Int = lottoResults[lottoRanking]?.let { lottoResults[lottoRanking] } ?: 0
            sum += lottoRanking.price.times(lottoResult)
        }
        return sum.toFloat() / inputMoney
    }

    private fun addLottoRankingCount(lottoRanking: LottoRanking) {
        lottoResults[lottoRanking]?.let { lottoResults.run { put(lottoRanking, it.plus(1)) } }
    }
}
