package lotto.domain

class Ranking(lotteryGroup: LotteryGroup, private val winNumber: Lottery, private val bonusNumber: LottoNumber) {

    var rankingResult = mutableMapOf<Rank, Int>()
        private set

    var totalWinAmount: Int = 0
        private set
        get() = rankingResult.toList().sumOf { (rank, count) ->
            rank.winningMoney * count
        }

    init {
        Rank.values().forEach {
            rankingResult[it] = 0
        }

        checkRanking(lotteryGroup)
    }

    private fun checkRanking(lotteries: LotteryGroup) {
        lotteries.lotteries.forEach {
            val rank = getRank(it)
            val rankingCount = rankingResult[rank] ?: 0
            rankingResult[rank] = rankingCount + 1
        }
    }

    private fun getRank(lottoNumber: Lottery): Rank {
        val size = lottoNumber.lottery.count {
            it in winNumber.lottery
        }
        val isBonusMatched = lottoNumber.lottery.any {
            it == bonusNumber
        }
        return Rank.valueOf(size, isBonusMatched)
    }
}
