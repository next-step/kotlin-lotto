package lottery.domain

enum class RankPrinter(val rank: Rank, val content: String) {
    FIFTH(Rank.FIFTH, "${Rank.FIFTH.matchCount}개 일치"),
    FOURTH(Rank.FOURTH, "${Rank.FOURTH.matchCount}개 일치"),
    THIRD(Rank.THIRD, "${Rank.THIRD.matchCount}개 일치"),
    SECOND(Rank.SECOND, "${Rank.SECOND.matchCount}개 일치, 보너스 볼 일치"),
    FIRST(Rank.FIRST, "${Rank.FIRST.matchCount}개 일치");

    companion object {
        fun valueOf(rank: Rank): RankPrinter {
            return values().first { it.rank == rank }
        }
    }
}
