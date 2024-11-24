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

enum class Reward(
    val money: Int,
    val matchingNumberCount: Int,
) {
    FIRST(2_000_000_000, 6),
    SECOND(1_500_000, 5),
    THIRD(50_000, 4),
    FOURTH(5_000, 3),
    NONE(0, 0)
    ;

    companion object {
        fun of(matchingNumberCount: Int): Reward =
            entries.filter { it != NONE }
                .find { it.matchingNumberCount == matchingNumberCount }
                ?: NONE
    }
}
