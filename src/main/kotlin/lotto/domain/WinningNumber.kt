package lotto.domain

data class WinningNumber(
    val lastLottoNumbers: LottoNumbers,
    val bonusNumber: LottoNumber
) {
    init {
        validateDuplicateBonusNumberWithLottoNumbers(lastLottoNumbers, bonusNumber)
    }

    private fun validateDuplicateBonusNumberWithLottoNumbers(
        lottoNumbers: LottoNumbers,
        bonusNumber: LottoNumber
    ) {
        require(!lottoNumbers.contains(bonusNumber)) { "보너스 번호는 로또 번호와 달라야 합니다." }
    }
}
