package lotto

enum class Reward(
    val money: Int,
    val matchingNumberCount: Int,
    private val isMatch: (matchingNumberCount: Int, matchBonusNumber: Boolean) -> Boolean,
) {
    FIRST(2_000_000_000, 6, { matchingNumberCount, _ -> matchingNumberCount == 6 }) ,
    SECOND(30_000_000, 5, { matchingNumberCount, matchBonusNumber -> matchingNumberCount == 5 && matchBonusNumber }),
    THIRD(1_500_000, 5, { matchingNumberCount, _ -> matchingNumberCount == 5 }),
    FOURTH(50_000, 4, { matchingNumberCount, _ -> matchingNumberCount == 4 }),
    FIFTH(5_000, 3, { matchingNumberCount, _ -> matchingNumberCount == 3 }),
    NONE(0, 0, { matchingNumberCount, _ -> matchingNumberCount < 3 })
    ;

    companion object {
        fun of(
            matchingNumberCount: Int,
            matchBonusNumber: Boolean,
        ): Reward =
            entries.filter { it != NONE }
                .find { it.isMatch(matchingNumberCount, matchBonusNumber) }
                ?: NONE
    }
}
