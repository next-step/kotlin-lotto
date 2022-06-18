package lotto.domain

data class LottoGameResult(
    val ranks: List<Rank>,
    val profit: Double
) {
    val rankMap: Map<Rank, Int> = ranks.groupingBy { it }.eachCount()
}
