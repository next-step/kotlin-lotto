package lotto.model

class DrawNumbers(
    val winningNumbers: Lotto,
    val bonusNumber: LottoNumber
) {

    init {
        validateUnique(winningNumbers, bonusNumber)
    }

    private fun validateUnique(winningNumbers: Lotto, bonusNumber: LottoNumber) =
        require(!winningNumbers.contains(bonusNumber)) { "당첨 번호와 보너스 번호는 중복될 수 없습니다. (중복 번호: $bonusNumber)" }
}