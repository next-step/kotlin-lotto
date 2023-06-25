package lotto.domain

data class WinningNumber(
    val lastLotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        validateDuplicateBonusNumberWithLottoNumbers(lastLotto, bonusNumber)
    }

    private fun validateDuplicateBonusNumberWithLottoNumbers(
        lotto: Lotto,
        bonusNumber: LottoNumber
    ) {
        require(!lotto.contains(bonusNumber)) { "보너스 번호는 로또 번호와 달라야 합니다." }
    }
}
