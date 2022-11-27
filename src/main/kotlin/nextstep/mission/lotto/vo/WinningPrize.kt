package nextstep.mission.lotto.vo

enum class WinningPrize(val matchedCount: Int, val prize: Int) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 1_500_000),
    THIRD(4, 50_000),
    FOURTH(3, 5_000);

    companion object {
        fun find(matchedCount: Int): WinningPrize? = values().find { it.matchedCount == matchedCount }
    }
}
