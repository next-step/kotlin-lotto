package lotto.domain

import lotto.domain.enum.Priority

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

    fun calculateStatistics(
        lottos: List<LottoTicket>,
        winningNumbers: List<Int>
    ): Map<Int, Int> {
        return MATCHING_NUMBER_RANGE.associateWith { matchCounts(it, lottos, winningNumbers) }
    }

    private fun matchCounts(
        matchNumber: Int,
        lottos: List<LottoTicket>,
        winningNumbers: List<Int>
    ): Int {
        var result = 0

        for (lotto in lottos) {
            result += matchCount(matchNumber, lotto, winningNumbers)
        }

        return result
    }

    private fun matchCount(
        matchNumber: Int,
        lotto: LottoTicket,
        winningNumbers: List<Int>
    ): Int {
        val containCount = lotto.numbers.filter { winningNumbers.contains(it) }.size
        return if (containCount == matchNumber) 1 else 0
    }

    fun calculateReturnRate(price: Int, statistics: Map<Int, Int>): Double {
        return (calculateReturnPrice(statistics) / price.toDouble())
    }

    private fun calculateReturnPrice(statistics: Map<Int, Int>): Int {
        var returnPrice = 0

        for ((matchNumber, matchCount) in statistics) {
            returnPrice += matchCount * Priority.getPrice(matchNumber)
        }

        return returnPrice
    }
}
