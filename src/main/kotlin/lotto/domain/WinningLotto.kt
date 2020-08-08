package lotto.domain

class WinningLotto(
    private val winningNumbers: Lotto,
    bonusNumber: LottoNumber
) {
    private val _bonusNumber = bonusNumber
    val bonusNumber: LottoNumber
        get() = _bonusNumber

    init {
        validateDuplication(winningNumbers, bonusNumber)
    }

    private fun validateDuplication(winningNumbers: Lotto, bonus: LottoNumber) {
        require(!winningNumbers.contains(bonus)) { "Bonus is Duplicate : $bonus should be unique value" }
    }

    fun contains(value: LottoNumber): Boolean {
        return winningNumbers.contains(value)
    }
}
