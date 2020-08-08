package lotto.domain

import lotto.LOTTO_NUMBERS_SIZE

data class LottoNumbers(private val numbers: List<Int>) {

    init {
        validateSize(numbers)
        validateDuplication(numbers)
    }

    private fun validateSize(numbers: List<Int>) {
        if (numbers.size != LOTTO_NUMBERS_SIZE) {
            throw IllegalArgumentException("Invalid lotto numbers size : ${numbers.size}")
        }
    }

    private fun validateDuplication(numbers: List<Int>) {
        val noDuplicationNumbers = numbers.toSet()
        if (noDuplicationNumbers.size != LOTTO_NUMBERS_SIZE) {
            throw IllegalArgumentException("There is duplication in Lotto numbers : $noDuplicationNumbers")
        }
    }

    fun isMatchedUp(luckyNumber: Int): Boolean {
        return numbers.contains(luckyNumber)
    }

    override fun toString(): String {
        return "$numbers"
    }
}
