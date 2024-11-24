package lotto

class WinningLotto(
    private val lotto: Lotto,
) {
    fun match(lotto: Lotto): Reward {
        val matchingNumberCount = this.lotto
            .numbers
            .count { lotto.numbers.contains(it) }
        return Reward.of(matchingNumberCount)
    }
}
