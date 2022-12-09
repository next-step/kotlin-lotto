package lotto

class WinningMachine(winningString: String) {

    val winningNumbers: List<LottoNumber>

    init {
        val stringNumbers = getStringNumbers(winningString)
        winningNumbers = getWinningNumbers(stringNumbers)
        require(winningNumbers.size == winningNumbers.distinct().size) { "input string numbers duplicates" }
    }

    private fun getStringNumbers(winningString: String): List<String> {
        val stringNumbers = winningString.split(",")

        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        require(stringNumbers.size == LOTTO_NUMBERS_COUNT) { "input string delimiter count" }

        return stringNumbers
    }

    private fun getWinningNumbers(stringNumbers: List<String>): List<LottoNumber> {
        return stringNumbers.map { LottoNumber(it.trim()) }
    }

    fun winningResult(lottoList: List<Lotto>): HashMap<RANKING, Int> {
        val winningResult = HashMap<RANKING, Int>()

        lottoList.forEach { lotto ->
            val union = lotto.publishNumbers + winningNumbers
            setWinningResultValue(union, winningResult)
        }

        return winningResult
    }

    private fun setWinningResultValue(unionNumbers: List<LottoNumber>, winningResult: HashMap<RANKING, Int>) {
        when (unionNumbers.size - unionNumbers.distinct().size) {
            RANKING.FOURTH.winningCount -> {
                setWinningRankingValue(RANKING.FOURTH, winningResult)
            }
            RANKING.THIRD.winningCount -> {
                setWinningRankingValue(RANKING.THIRD, winningResult)
            }
            RANKING.SECOND.winningCount -> {
                setWinningRankingValue(RANKING.SECOND, winningResult)
            }
            RANKING.FIRST.winningCount -> {
                setWinningRankingValue(RANKING.FIRST, winningResult)
            }
        }
    }

    private fun setWinningRankingValue(rank: RANKING, winningResult: HashMap<RANKING, Int>) {
        var winningCount: Int = winningResult[rank] ?: 0
        winningResult[rank] = ++ winningCount
    }

    companion object {
        private const val LOTTO_NUMBERS_COUNT = 6
    }
}
