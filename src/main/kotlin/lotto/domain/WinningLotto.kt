package lotto.domain

data class WinningLotto(val lottoNumbers: LottoNumbers, val bonusNumber: LottoNumber) {

    init {
        validateBonusBall()
    }

    private fun validateBonusBall() {
        require(bonusNumber !in lottoNumbers.numbers) {
            "보너스 볼은 당첨 번호와 중복될 수 없습니다."
        }
    }
}
