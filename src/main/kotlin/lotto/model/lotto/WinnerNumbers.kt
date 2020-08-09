package lotto.model.lotto

class WinnerNumbers(
    private val numbers: Numbers,
    private val bonusBall: LottoNumber
) {
    init {
        validationBonusNumber()
    }

    fun getNumbers() = numbers

    fun getBonusBall() = bonusBall

    private fun validationBonusNumber() {
        require(numbers.isMatch(bonusBall).not()) { "보너스 번호와 중복될순 없습니다." }
    }
}
