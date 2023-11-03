package lotto.domain

class WinningLotto(val lotto: Lotto, val bonusBall: LottoNumber) {

    init {
        validateBonusBall()
    }

    private fun validateBonusBall() {
        require(bonusBall.number !in lotto.numbers) {
            "보너스 볼은 당첨 번호와 중복될 수 없습니다."
        }
    }
}
