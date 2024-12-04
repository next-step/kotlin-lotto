package lotto.domain

enum class Reward(
    val money: Int,
    val matchingNumberCount: Int,
    private val isMatch: (matchingNumberCount: Int, matchBonusNumber: Boolean) -> Boolean,
) {
    FIRST(
        money = 2_000_000_000,
        matchingNumberCount = 6,
        { matchingNumberCount, _ -> matchingNumberCount == FIRST.matchingNumberCount }
    ) ,
    SECOND(
        money = 30_000_000,
        matchingNumberCount = 5,
        { matchingNumberCount, matchBonusNumber -> matchingNumberCount == SECOND.matchingNumberCount && matchBonusNumber }
    ),
    THIRD(
        money = 1_500_000,
        matchingNumberCount = 5,
        { matchingNumberCount, _ -> matchingNumberCount == THIRD.matchingNumberCount }
    ),
    FOURTH(
        money = 50_000,
        matchingNumberCount = 4,
        { matchingNumberCount, _ -> matchingNumberCount == FOURTH.matchingNumberCount }
    ),
    FIFTH(
        money = 5_000,
        matchingNumberCount = 3,
        { matchingNumberCount, _ -> matchingNumberCount == FIFTH.matchingNumberCount }
    ),
    NONE(
        money = 0,
        matchingNumberCount = 0,
        { matchingNumberCount, _ -> matchingNumberCount < FIFTH.matchingNumberCount }
    );

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
