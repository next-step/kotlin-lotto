package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
    private val bonusBall: LottoNumber,
) {
    init {
        require(!lotto.containsLottoNumber(bonusBall)) { "보너스볼은 당첨 로또 번호와 중복될 수 없습니다." }
    }

    fun match(targetLotto: Lotto): Rank {
        val correctNumber = lotto.countSameLottoNumbers(targetLotto)
        val isMatchedBonusBall = targetLotto.containsLottoNumber(bonusBall)
        return Rank.of(correctNumber, isMatchedBonusBall)
    }
}
