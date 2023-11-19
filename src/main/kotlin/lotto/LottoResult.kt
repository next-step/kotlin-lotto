package lotto

data class LottoResult(
    val lottoRanking: Map<Prize, Int>,
    val totalPrize: Int,
    val lottoCount: Int,
)
