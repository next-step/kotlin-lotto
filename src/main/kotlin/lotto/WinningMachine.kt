package lotto

class WinningMachine(winningString: String) {

    val winningLotto: Lotto

    init {
        val stringNumbers = getStringNumbers(winningString)
        winningLotto = Lotto(getWinningNumbers(stringNumbers))
    }

    private fun getStringNumbers(winningString: String): List<String> {
        val stringNumbers = winningString.split(",")

        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        require(stringNumbers.size == LOTTO_NUMBERS_COUNT) { "input string delimiter count" }

        return stringNumbers
    }

    private fun getWinningNumbers(stringNumbers: List<String>): List<LottoNumber> {
        val lottoNumbers = stringNumbers.map { LottoNumber(it.trim()) }
        require(lottoNumbers.size == lottoNumbers.distinct().size) { "input string numbers duplicates" }
        return lottoNumbers
    }

    fun winningResult(lottoList: List<Lotto>): HashMap<RANKING, Int> {
        val winningResult = HashMap<RANKING, Int>()

        lottoList.forEach { lotto ->
            val union = lotto.numbers + winningLotto.numbers
            setWinningResultValue(union, winningResult)
        }

        return winningResult
    }

    private fun setWinningResultValue(unionNumbers: List<LottoNumber>, winningResult: HashMap<RANKING, Int>) {
        val ranking = RANKING.countOf(unionNumbers.size - unionNumbers.distinct().size)
        setWinningRankingValue(ranking, winningResult)
    }

    private fun setWinningRankingValue(rank: RANKING, winningResult: HashMap<RANKING, Int>) {
        var winningCount: Int = winningResult[rank] ?: 0
        winningResult[rank] = ++ winningCount
    }

    companion object {
        private const val LOTTO_NUMBERS_COUNT = 6
    }
}
