package lotto.domain

data class LottoResult(
    private val lottoGames: LottoGameList,
    private val lastWeekNumber: LastWeekNumber,
    private val bonusNumber: BonusNumber
) {
    private val lottoResultMap = initLottoResultMap()

    init {
        val lastWeekNumberSet = lastWeekNumber.getLastWeekSetList()
        val numberOfHits = lottoGames
            .getGames()
            .map { getGameResults(it, lastWeekNumberSet, bonusNumber) }

        numberOfHits
            .forEach {
                val currentWinningType = LotteryWinningTypes.findTypeByLottoGameResult(it)
                lottoResultMap[currentWinningType] = lottoResultMap.getOrDefault(currentWinningType, 0) + 1
            }
    }

    constructor(lotteryPaper: LotteryPaper, lastWeekNumber: LastWeekNumber, bonusNumber: BonusNumber) : this(
        lotteryPaper.getLottoGameList(),
        lastWeekNumber,
        bonusNumber
    )

    fun getLottoResultMap() = lottoResultMap.toMap()

    fun getLottoResultMapOnlyWinning() =
        lottoResultMap
            .filter { it.key.result.numberOfHit >= LotteryWinningTypes.MINIMUM_WINNING_HITS }
            .toSortedMap(compareBy { it.lottoWinning.winning })

    private fun initLottoResultMap(): LinkedHashMap<LotteryWinningTypes, Int> {
        val lottoResultMap = LinkedHashMap<LotteryWinningTypes, Int>()
        LotteryWinningTypes
            .values()
            .forEach { lottoResultMap[it] = 0 }
        return lottoResultMap
    }

    private fun getGameResults(
        lottoGame: LottoGame,
        lastWeekNumberSet: Set<LottoNumber>,
        bonusNumber: BonusNumber
    ): LottoGameResult {
        val hits = lottoGame.numbers.filter { number -> lastWeekNumberSet.contains(number) }.size
        val containBonus = lottoGame.numbers.contains(bonusNumber.number)
        return LottoGameResult(LottoHit(hits), BonusAble(containBonus))
    }
}
