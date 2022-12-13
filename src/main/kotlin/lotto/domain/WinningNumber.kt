package lotto.domain

class WinningNumber private constructor(winningLotto: Lotto, bonusNumber: LottoNumber) {
    val lotto = winningLotto.elements

    companion object {
        private const val DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE = "보너스 번호는 6개의 당첨 번호와 중복될 수 없습니다. : [%d]"

        fun of(inputWinningLotto: Set<Int>, inputBonusNumber: Int): WinningNumber {
            val winningLotto = Lotto.of(inputWinningLotto)
            val bonusNumber = LottoNumber.of(inputBonusNumber)
            validateBonusNumber(winningLotto, bonusNumber)
            return WinningNumber(winningLotto, bonusNumber)
        }

        private fun validateBonusNumber(winningLotto: Lotto, bonusNumber: LottoNumber): Unit =
            require(!winningLotto.contain(bonusNumber)) { DUPLICATED_BONUS_NUMBER_ERROR_MESSAGE.format(bonusNumber.value) }
    }
}
