package nextstep.mission.lotto.vo

enum class WinningPrize(val matchedCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000);

    companion object {
        fun find(matchedCount: Int): WinningPrize? = values().find { it.matchedCount == matchedCount }

        fun find(matchedCount: Int, bonusMatched: Boolean): WinningPrize? =
            values().find { it.matchedCount == matchedCount }
                ?.let {
                    if (matchedCount == 5) {
                        return if (bonusMatched) SECOND else THIRD
                    } else {
                        return it
                    }
                }
    }
}
