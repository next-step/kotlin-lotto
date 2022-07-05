package lotto.domain

data class LottoGameResult(
    val rankMap: Map<Rank, Int>,
    val profit: Double
) {
    constructor(ranks: List<Rank>, profit: Double) : this(
        rankMap = ranks.groupingBy { it }.eachCount(),
        profit = profit
    )
}
