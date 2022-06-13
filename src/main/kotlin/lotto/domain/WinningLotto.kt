package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
    private val bonusBall: LottoNumber,
) {
    fun match(targetLotto: Lotto): Rank {
        val correctNumber = lotto.countSameLottoNumbers(targetLotto)
        val isMatchedBonusBall = targetLotto.containsLottoNumber(bonusBall)
        return Rank.of(correctNumber, isMatchedBonusBall)
    }
}
