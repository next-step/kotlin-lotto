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
            val winningNumbers = winningLotto.numbers.filter { lotto.numbers.contains(it) }
            setWinningResultValue(winningNumbers.size, winningResult)
        }

        return winningResult
    }

    private fun setWinningResultValue(winningCount: Int, winningResult: HashMap<RANKING, Int>) {
        val ranking = RANKING.countOf(winningCount)
        setWinningRankingValue(ranking, winningResult)
    }

    private fun setWinningRankingValue(rank: RANKING, winningResult: HashMap<RANKING, Int>) {
        var winningCount: Int = winningResult[rank] ?: 0
        winningResult[rank] = ++ winningCount
    }
}
