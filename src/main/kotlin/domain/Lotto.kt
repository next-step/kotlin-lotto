package domain

import domain.LottoWinningType.NONE

data class Lotto(
    val numbers: Set<Int>,
) {
    init {
        require(numbers.size == SIZE) {
            "A lotto must contain exactly $SIZE unique numbers."
        }

        require(numbers.all { it in MIN_NUMBER..MAX_NUMBER }) {
            "Lotto numbers must be between $MIN_NUMBER and $MAX_NUMBER."
        }
    }

    fun determineWinningType(winningNumbers: Set<Int>): LottoWinningType {
        val matchingCount = winningNumbers.intersect(numbers).count()
        return LottoWinningType.entries.find { it.matchingCount == matchingCount } ?: NONE
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        const val SIZE = 6
    }
}
