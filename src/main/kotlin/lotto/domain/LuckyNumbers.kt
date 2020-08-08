package lotto.domain

import lotto.LOTTO_NUMBERS_SIZE

class LuckyNumbers(private val luckyNumbers: List<Int>) {

    init {
        validateSize(luckyNumbers)
        validateDuplication(luckyNumbers)
    }

    private fun validateSize(luckyNumbers: List<Int>) {
        if (luckyNumbers.size != LOTTO_NUMBERS_SIZE) {
            throw IllegalArgumentException("Invalid lucky numbers size : ${luckyNumbers.size}")
        }
    }

    private fun validateDuplication(luckyNumbers: List<Int>) {
        val noDuplicationLuckyNumbers = luckyNumbers.toSet()
        if (noDuplicationLuckyNumbers.size != LOTTO_NUMBERS_SIZE) {
            throw IllegalArgumentException("There is duplication in lucky numbers : $noDuplicationLuckyNumbers")
        }
    }

    fun getMatchedCount(lottoNumbers: LottoNumbers): Int {
        return luckyNumbers.filter { lottoNumbers.isMatchedUp(it) }.size
    }

    fun hasBonusNumber(bonusNumber: Int) = luckyNumbers.contains(bonusNumber)
}
