package lotto.domain

data class LottoResult(private val lottoGames: List<LottoGame>, private val lastWeekNumber: LastWeekNumber) {
    private val lottoResultMap = HashMap<Int, Int>().apply {
        put(3, 0)
        put(4, 0)
        put(5, 0)
        put(6, 0)
    }

    init {
        val lastWeekNumberSet = lastWeekNumber.getLastWeekSetList()
        val numberOfHits = lottoGames
            .map { getGameHits(it, lastWeekNumberSet) }
        numberOfHits
            .filter { it >= 3 }
            .forEach { lottoResultMap[it] = lottoResultMap.getOrDefault(it, 0) + 1 }
    }

    constructor(lotteryPaper: LotteryPaper, lastWeekNumber: LastWeekNumber) : this(
        lotteryPaper.getLottoGames(),
        lastWeekNumber
    )

    fun getLottoResultMap() = lottoResultMap.toMap()

    private fun getGameHits(lottoGame: LottoGame, lastWeekNumberSet: Set<Int>): Int =
        lottoGame.getNumbers().filter { number -> lastWeekNumberSet.contains(number) }.size
}
