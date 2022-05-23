package lotto.domain

object LottoCommittee {
    private const val LOTTO_NUMBER_COUNT = 6
    private val MATCHING_NUMBER_RANGE = 3..6
    private val LOTTO_VALID_RANGE = 1..45
    val MATCH_PRICE_MAP = mapOf(
        3 to 5_000,
        4 to 50_000,
        5 to 1_500_000,
        6 to 2_000_000_000
    )

    fun createWinningNumbers(input: String): List<Int> {
        val winningNumbers = input
            .filter { !it.isWhitespace() }
            .split(",")
            .map { it.toInt() }
            .filter { it in LOTTO_VALID_RANGE }

        return if (winningNumbers.size == LOTTO_NUMBER_COUNT) winningNumbers
        else throw IllegalArgumentException("입력 값에 문제가 있습니다.")
    }

    fun calculateStatistics(
        lottos: List<List<Int>>,
        winningNumbers: List<Int>
    ): Map<Int, Int> {
        val statistics = mutableMapOf<Int, Int>()

        for (matchNumber in MATCHING_NUMBER_RANGE) {
            statistics[matchNumber] = matchCount(matchNumber, lottos, winningNumbers)
        }

        return statistics
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

    fun calculateReturnRate(price: Int, statistics: Map<Int, Int>): Double {
        return (calculateReturnPrice(statistics) / price.toDouble())
    }

    private fun calculateReturnPrice(statistics: Map<Int, Int>): Int {
        var returnPrice = 0

        for ((matchNumber, matchCount) in statistics) {
            returnPrice += matchCount * getPrice(matchNumber)
        }

        return returnPrice
    }

    private fun getPrice(matchNumber: Int): Int {
        return MATCH_PRICE_MAP[matchNumber] ?: 0
    }
}
