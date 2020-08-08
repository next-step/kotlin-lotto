package lotto.domain

import lotto.LottoUtils.luckyNumbers

class BonusNumber(private val _bonusNumber: Int) {
    val bonusNumber: Int
        get() = _bonusNumber

    init {
        validateBound()
        validateDuplication(bonusNumber, luckyNumbers)
    }

    private fun validateBound() {
        if (_bonusNumber !in 1..45)
            throw IllegalArgumentException("Bonus number is out of Bounds : $bonusNumber")
    }

    private fun validateDuplication(bonusNumber: Int, luckyNumbers: LuckyNumbers) {
        if (luckyNumbers.hasBonusNumber(bonusNumber))
            throw IllegalArgumentException("Duplication between lucky numbers and bonus number : $bonusNumber")
    }
}
