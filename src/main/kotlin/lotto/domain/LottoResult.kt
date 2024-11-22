package lotto.domain

class LottoResult(
    val lottos: List<Lotto>,
    val lottoResultMap: Map<Int, Int>,
    val profitRate: Double,
)
