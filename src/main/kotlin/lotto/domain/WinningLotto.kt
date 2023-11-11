package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber,
) {

    init {
        validateBonusBall(lotto, bonusNumber)
    }

    fun getLottoNumbers(): Set<LottoNumber> =
        lotto.sortedNumbers.toSet()

    private fun validateBonusBall(winningLotto: Lotto, bonusBall: LottoNumber) {
        require(winningLotto.hasBonusBall(bonusBall).not()) {
            "보너스 볼은 당첨 번호와 중복될 수 없습니다."
        }
    }
}
