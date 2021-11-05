package lotto.domain

data class LottoResult(private val lottoGames: List<LottoGame>, private val lastWeekNumber: LastWeekNumber) {
    private val lottoResultMap = LinkedHashMap<LotteryWinningTypes, Int>().apply {
        LotteryWinningTypes.values().forEach { put(it, 0) }
    }

    init {
        val lastWeekNumberSet = lastWeekNumber.getLastWeekSetList()
        val numberOfHits = lottoGames
            .map { getGameHits(it, lastWeekNumberSet) }

        numberOfHits
            .forEach {
                val currentWinningType = LotteryWinningTypes.findTypeByHits(it)
                lottoResultMap[currentWinningType] = lottoResultMap.getOrDefault(currentWinningType, 0) + 1
            }
    }

    constructor(lotteryPaper: LotteryPaper, lastWeekNumber: LastWeekNumber) : this(
        lotteryPaper.getLottoGames(),
        lastWeekNumber
    )

    fun getLottoResultMap() = lottoResultMap.toMap()

    fun getLottoResultMapOnlyWinning() =
        lottoResultMap.filter { it.key.hits >= LotteryWinningTypes.MINIMUM_WINNING_HITS }

    private fun getGameHits(lottoGame: LottoGame, lastWeekNumberSet: Set<Int>): Int =
        lottoGame.numbers.filter { number -> lastWeekNumberSet.contains(number) }.size
}
