package lotto.domain

class Ranking(buyedLottoes: LottoNumbers, private val winNumber: LottoNumber, private val bonusNumber: BonusNumber) {

    var rankingResult = mutableMapOf<Rank, Int>()
        private set

    var totalWinAmount: Int = 0
        private set
        get() = rankingResult.toList().sumOf { (rank, count) ->
            rank.winningMoney * count
        }

    init {
        buyedLottoes.lottoNumbers.forEach {
            val rank = getRank(it)
            val rankingCount = rankingResult[rank] ?: 0
            rankingResult[getRank(it)] = rankingCount + 1
        }
    }

    private fun getRank(lottoNumber: LottoNumber): Rank {
        val size = lottoNumber.lottoNumber.filter {
            it in winNumber.lottoNumber
        }.size
        val isBonusMatched = lottoNumber.lottoNumber.any {
            it == bonusNumber.bonusNumber
        }
        return Rank.valueOf(size, isBonusMatched)
    }
}