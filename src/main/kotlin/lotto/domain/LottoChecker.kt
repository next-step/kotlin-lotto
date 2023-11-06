package lotto.domain

class LottoChecker() {
    fun getWinNum(lotto: Lotto, winningNumbers: List<Int>): Int {
        val lottoNums = lotto.numbers
        return lottoNums.intersect(winningNumbers).size
    }

    fun getWinNumStatistics(lottos: Lottos, winningNumbers: List<Int>): Map<Int, Int> {
        val statistics = mutableMapOf<Int, Int>()
        val lottoList = lottos.lottoList
        lottoList.forEach { lotto: Lotto ->
            val winNum = getWinNum(lotto, winningNumbers)

            statistics[winNum] = statistics.getOrDefault(winNum, 0) + 1
        }
        return statistics
    }
}
