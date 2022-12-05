package lotto.domain

class LottoMatchList(
    val lottoMatchList: MutableList<LottoMatch>
) {
    init {
        val lottoRanks = lottoMatchList.map {
            it.lottoRank
        }

        val missing = findMissingList(lottoRanks)

        lottoMatchList.addAll(missing)

        lottoMatchList.sortBy { it.lottoRank.ordinal }
    }

    fun sumLottoMatchProfit(): Long =
        lottoMatchList.sumOf { lottoMatch ->
            lottoMatch.getProfit()
        }

    private fun findMissingList(lottoRanks: List<LottoRank>): List<LottoMatch> =
        LottoRank.getMissing(lottoRanks.toMutableSet())
            .map { missingLottoRank ->
                LottoMatch(missingLottoRank)
            }
}
