package lotto

class WinningMachine(winningString: String) {

    val winningNumbers: List<Int>

    init {
        val stringNumbers = winningString.split(",")
        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        require(stringNumbers.size == Const.LOTTO_NUMBERS_COUNT) { "input string delimiter count" }

        this.winningNumbers = stringNumbers.map { numberString -> numberString.trim().toInt() }
            .filterNot { number -> number > Const.LOTTO_MAX_RANDOM_VALUE || number <= 0 }

        require(this.winningNumbers.size == 6) { "input string numbers range" }
        require(this.winningNumbers.size == this.winningNumbers.distinct().size) { "input string numbers duplicates" }
    }

    fun winningResult(lottoList: List<Lotto>): HashMap<Const.RANKING, Int> {
       val winningResult = HashMap<Const.RANKING, Int>()

        lottoList.forEach { lotto ->
            val union = lotto.publishNumbers + winningNumbers

            when (union.size - union.distinct().size) {
                Const.RANKING.FOURTH.winningCount -> {
                    setWinningPlaceValue(Const.RANKING.FOURTH, winningResult)
                }
                Const.RANKING.THIRD.winningCount -> {
                    setWinningPlaceValue(Const.RANKING.THIRD, winningResult)
                }
                Const.RANKING.SECOND.winningCount -> {
                    setWinningPlaceValue(Const.RANKING.SECOND, winningResult)
                }
                Const.RANKING.FIRST.winningCount -> {
                    setWinningPlaceValue(Const.RANKING.FIRST, winningResult)
                }
            }
        }

        return winningResult
    }

    private fun setWinningPlaceValue(place: Const.RANKING, winningResult: HashMap<Const.RANKING, Int>) {
        var winningCount: Int = winningResult[place] ?: 0
        winningResult[place] = ++ winningCount
    }
}
