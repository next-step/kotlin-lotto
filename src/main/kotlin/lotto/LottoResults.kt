package lotto

class LottoResults(ranks: List<LottoRank>) {
    val resultCountByRank: Map<LottoRank, Int> = ranks.groupingBy { it }.eachCount()
}
