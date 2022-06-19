package lotto.view

data class LottoResponses(
    val lottos: List<LottoResponse>
)

data class LottoResponse(
    val numbers: List<Int>
)
