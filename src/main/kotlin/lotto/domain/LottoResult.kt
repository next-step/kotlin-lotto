package lotto.domain

data class LottoResult(
    private val lottoGames: List<LottoGame>,
    private val lastWeekNumber: LastWeekNumber,
    private val bonusNumber: BonusNumber
) {
    private val lottoResultMap = LinkedHashMap<LotteryWinningTypes, Int>().apply {
        LotteryWinningTypes.values().forEach { put(it, 0) }
    }

    init {
        val lastWeekNumberSet = lastWeekNumber.getLastWeekSetList()
        val numberOfHits = lottoGames
            .map { getGameResults(it, lastWeekNumberSet, bonusNumber) }

        numberOfHits
            .forEach {
                val currentWinningType = LotteryWinningTypes.findTypeByLottoGameResult(it)
                lottoResultMap[currentWinningType] = lottoResultMap.getOrDefault(currentWinningType, 0) + 1
            }
    }

    constructor(lotteryPaper: LotteryPaper, lastWeekNumber: LastWeekNumber, bonusNumber: BonusNumber) : this(
        lotteryPaper.getLottoGames(),
        lastWeekNumber,
        bonusNumber
    )

    fun getLottoResultMap() = lottoResultMap.toMap()

    fun getLottoResultMapOnlyWinning() =
        lottoResultMap
            .filter { it.key.result.numberOfHit >= LotteryWinningTypes.MINIMUM_WINNING_HITS }
            .toSortedMap(compareBy { it.winnings })

    private fun getGameResults(
        lottoGame: LottoGame,
        lastWeekNumberSet: Set<Int>,
        bonusNumber: BonusNumber
    ): LottoGameResult {
        val hits = lottoGame.numbers.filter { number -> lastWeekNumberSet.contains(number) }.size
        val containBonus = lottoGame.numbers.contains(bonusNumber.number)
        return LottoGameResult(hits, containBonus)
    }
}
