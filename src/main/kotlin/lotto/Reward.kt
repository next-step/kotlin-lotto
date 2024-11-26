package lotto

enum class Reward(
    val money: Int,
    val isMatch: (matchingNumberCount: Int, matchBonusNumber: Boolean) -> Boolean,
) {
    FIRST(2_000_000_000, { matchingNumberCount, _ -> matchingNumberCount == 6 }) ,
    SECOND(30_000_000, { matchingNumberCount, matchBonusNumber -> matchingNumberCount == 5 && matchBonusNumber }),
    THIRD(1_500_000, { matchingNumberCount, _ -> matchingNumberCount == 5 }),
    FOURTH(50_000, { matchingNumberCount, _ -> matchingNumberCount == 4 }),
    FIFTH(5_000, { matchingNumberCount, _ -> matchingNumberCount == 3 }),
    NONE(0, { matchingNumberCount, _ -> matchingNumberCount < 3 })
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
