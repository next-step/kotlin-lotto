package lottery.domain.rank

fun interface RankingMetric {
    fun rank(matchCount: Int, isBonus: Boolean): Boolean
}
