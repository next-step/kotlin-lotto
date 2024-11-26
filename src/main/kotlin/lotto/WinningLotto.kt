package lotto

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: BonusNumber,
) {
    init {
        require(bonusNumber.value !in lotto.numbers) { "보너스 볼 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun match(lotto: Lotto): Reward {
        val matchingNumberCount = this.lotto
            .numbers
            .count { it in lotto.numbers }
        val matchBonusNumber = bonusNumber.isMatch(lotto)

        return Reward.of(matchingNumberCount, matchBonusNumber)
    }
}
