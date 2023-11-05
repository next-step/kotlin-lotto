package lotto.domain

data class LottoResult(
    private val ranks: Map<LottoRank, Int>
) {

    operator fun get(lottoWinning: LottoRank) = ranks[lottoWinning]
}
