package lotto.domain

class Ranking(buyedLottoes: OwnedLotto, private val winNumber: Lotto, private val bonusNumber: BonusBall) {

    var rankingResult = mutableMapOf<Rank, Int>()
        private set

    var totalWinAmount: Int = 0
        private set
        get() = rankingResult.toList().sumOf { (rank, count) ->
            rank.winningMoney * count
        }

    init {
        Rank.values().reversedArray().forEach {
            rankingResult[it] = 0
        }

        buyedLottoes.lottoes.forEach {
            val rank = getRank(it)
            val rankingCount = rankingResult[rank] ?: 0
            rankingResult[rank] = rankingCount + 1
        }
    }

    private fun getRank(lottoNumber: Lotto): Rank {
        val size = lottoNumber.lotto.count {
            it in winNumber.lotto
        }
        val isBonusMatched = lottoNumber.lotto.any {
            it == bonusNumber.bonusNumber
        }
        return Rank.valueOf(size, isBonusMatched)
    }
}
