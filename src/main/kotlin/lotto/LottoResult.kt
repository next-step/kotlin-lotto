package lotto

data class LottoResult(
    val lottoRank: LottoRank,
    val count: Count = Count.zero(),
) {
    fun plus(): LottoResult {
        return LottoResult(lottoRank, count.plus())
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

    fun isSecondRank(): Boolean {
        return lottoRank == LottoRank.SECOND
    }
}
