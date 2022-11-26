package lotto

class WinningMachine(winningString: String) {

    val winningNumbers: List<Int>

    init {
        val stringNumbers = getStringNumbers(winningString)
        winningNumbers = getWinningNumbers(stringNumbers)
    }

    private fun getStringNumbers(winningString: String): List<String> {
        val stringNumbers = winningString.split(",")

        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        require(stringNumbers.size == Const.LOTTO_NUMBERS_COUNT) { "input string delimiter count" }

        return stringNumbers
    }

    private fun getWinningNumbers(stringNumbers: List<String>): List<Int> {
        val winningNumbers = stringNumbers.map { numberString -> numberString.trim().toInt() }
            .filterNot { number -> number > Const.LOTTO_MAX_RANDOM_VALUE || number <= 0 }

        require(winningNumbers.size == 6) { "input string numbers range" }
        require(winningNumbers.size == winningNumbers.distinct().size) { "input string numbers duplicates" }

        return winningNumbers
    }

    fun winningResult(lottoList: List<Lotto>): HashMap<Const.RANKING, Int> {
        val winningResult = HashMap<Const.RANKING, Int>()

        lottoList.forEach { lotto ->
            val union = lotto.publishNumbers + winningNumbers
            setWinningResultValue(union, winningResult)
        }

        return winningResult
    }

    private fun setWinningResultValue(unionNumbers: List<Int>, winningResult: HashMap<Const.RANKING, Int>) {
        when (unionNumbers.size - unionNumbers.distinct().size) {
            Const.RANKING.FOURTH.winningCount -> {
                setWinningRankingValue(Const.RANKING.FOURTH, winningResult)
            }
            Const.RANKING.THIRD.winningCount -> {
                setWinningRankingValue(Const.RANKING.THIRD, winningResult)
            }
            Const.RANKING.SECOND.winningCount -> {
                setWinningRankingValue(Const.RANKING.SECOND, winningResult)
            }
            Const.RANKING.FIRST.winningCount -> {
                setWinningRankingValue(Const.RANKING.FIRST, winningResult)
            }
        }
    }

    private fun setWinningRankingValue(rank: Const.RANKING, winningResult: HashMap<Const.RANKING, Int>) {
        var winningCount: Int = winningResult[rank] ?: 0
        winningResult[rank] = ++ winningCount
    }
}
