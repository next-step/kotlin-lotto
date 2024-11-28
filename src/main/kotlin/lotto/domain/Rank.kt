package lotto.domain

enum class Rank(
    val count: Int,
    val prize: Int,
    val match: (MatchStats) -> Boolean,
) {
    FIRST(6, 2_000_000_000, { stats -> stats.countEquals(6) }),
    SECOND(5, 30_000_000, { stats -> stats.countEquals(5) && stats.isBonusMatched }),
    THIRD(5, 1_500_000, { stats -> stats.countEquals(5) }),
    FOURTH(4, 50_000, { stats -> stats.countEquals(4) }),
    FIFTH(3, 5_000, { stats -> stats.countEquals(3) }),
    MISS(0, 0, { stats -> stats.countIsIn(0, 2) }),
    ;

    companion object {
        fun valueOf(stats: MatchStats): Rank =
            entries.firstOrNull { it.match(stats) }
                ?: throw IllegalArgumentException("${stats.count}개 일치, 보너스 볼 일치 = ${stats.isBonusMatched} 에 해당하는 등수가 없습니다.")
    }
}
