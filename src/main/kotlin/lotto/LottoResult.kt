package lotto

data class LottoResult(
    val lottoRank: LottoRank,
    val bonusMatch: Boolean = false,
) {
    var count: Int = 0

    fun count() {
        count++
    }

    fun sum(): Int {
        return lottoRank.sumPrice(count)
    }

    fun getMatchCount(): Int {
        return lottoRank.matchCount
    }

    fun getWinningPrice(): Int {
        return lottoRank.getPriceValue()
    }
}
