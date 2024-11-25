package lotto

enum class Reward(
    val money: Int,
    val matchingNumberCount: Int,
    val needMatchBonus: Boolean,
) {
    FIRST(2_000_000_000, 6, false),
    SECOND(30_000_000, 5, true),
    THIRD(1_500_000, 5, false),
    FOURTH(50_000, 4, false),
    FIFTH(5_000, 3, false),
    NONE(0, 0, false)
    ;

    companion object {
        fun of(
            matchingNumberCount: Int,
            matchBonusNumber: Boolean,
        ): Reward =
            entries.filter { it != NONE }
                .find {
                    it.matchingNumberCount == matchingNumberCount &&
                            (!it.needMatchBonus || matchBonusNumber)
                }
                ?: NONE
    }
}
