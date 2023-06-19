package lotto.domain

object LottoStatistics {
    private fun countMatchingNumbers(lastWinningNumber: List<Int>, lottoNumber: List<Int>): Int {
        val set1 = lastWinningNumber.toSet()
        val set2 = lottoNumber.toSet()
        return set1.intersect(set2).size
    }

    fun getLottoWinnerList(lastWinningNumber: List<Int>, lottoNumberArray: List<List<Int>>): MutableMap<Int, Int> {
        val resultMap = mutableMapOf(
            3 to 0,
            4 to 0,
            5 to 0,
            6 to 0
        )
        for (lottoNumber in lottoNumberArray) {
            val matchCount = countMatchingNumbers(lastWinningNumber, lottoNumber)
            if (matchCount >= 3) {
                resultMap.computeIfPresent(matchCount) { _, count -> count + 1 }
            }
        }
        return resultMap
    }

    fun getRateOfReturn(lottoResult: Map<Int, Int>, amount: Int): Float {
        val totalGainAmount = lottoResult.map { lotto -> LottoEnum.of(lotto.key) * lotto.value }.sum()
        return totalGainAmount.toFloat() / amount
    }
}
