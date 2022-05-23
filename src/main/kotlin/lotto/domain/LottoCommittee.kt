package lotto.domain

object LottoCommittee {
    private const val LOTTO_NUMBER_COUNT = 6
    private val MATCHING_NUMBER_RANGE = 3..6
    private val LOTTO_VALID_RANGE = 1..45

    fun createWinningNumbers(input: String): List<Int> {
        val winningNumbers = input
            .filter { !it.isWhitespace() }
            .split(",")
            .map { it.toInt() }
            .filter { it in LOTTO_VALID_RANGE }

        return if (winningNumbers.size == LOTTO_NUMBER_COUNT) winningNumbers
        else throw IllegalArgumentException("입력 값에 문제가 있습니다.")
    }

    fun createStatistics(
        lottos: List<List<Int>>,
        winningNumbers: List<Int>
    ): Map<Int, Int> {
        val statisticsMap = mutableMapOf<Int, Int>()

        for (matchNumber in MATCHING_NUMBER_RANGE) {
            statisticsMap[matchNumber] = matchCount(matchNumber, lottos, winningNumbers)
        }

        return statisticsMap
    }

    private fun matchCount(
        matchNumber: Int,
        lottos: List<List<Int>>,
        winningNumbers: List<Int>
    ): Int {
        var result = 0

        for (lotto in lottos) {
            val containCount = lotto.filter { winningNumbers.contains(it) }.size
            if (containCount == matchNumber) {
                result += 1
            }
        }

        return result
    }
}
