package lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    fun match(lotto: Lotto): Reward {
        val matchingNumberCount = this.lotto
            .numbers
            .count { it in lotto.numbers }
        val matchBonusNumber = bonusNumber.isMatch(lotto)

        return Reward.of(matchingNumberCount, matchBonusNumber)
    }
}
