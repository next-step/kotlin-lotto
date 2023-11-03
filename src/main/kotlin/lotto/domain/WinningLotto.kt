package lotto.domain

data class WinningLotto(val lottoNumbers: LottoNumbers, val bonusBall: LottoNumber) {

    init {
        validateBonusBall()
    }

    private fun validateBonusBall() {
        require(bonusBall !in lottoNumbers.numbers) {
            "보너스 볼은 당첨 번호와 중복될 수 없습니다."
        }
    }
}
