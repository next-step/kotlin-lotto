package lotto.domain

data class WinningLotto(val lottoNumbers: LottoNumbers, val bonusNumber: LottoNumber) {

    init {
        validateBonusBall()
    }

    fun match(targetNumbers: LottoNumbers): Pair<Int, Boolean> {
        return Pair(
            targetNumbers.matchNumbersCount(lottoNumbers),
            targetNumbers.matchNumbers(bonusNumber)
        )
    }

    private fun validateBonusBall() {
        require(bonusNumber !in lottoNumbers.numbers) {
            BONUS_NUMBER_ERROR_MESSAGE
        }
    }

    companion object {
        private const val BONUS_NUMBER_ERROR_MESSAGE = "보너스 볼은 당첨 번호와 중복될 수 없습니다."
    }
}