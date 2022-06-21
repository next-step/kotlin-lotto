package lotto.service

data class LottoResponses(
    val lottos: List<LottoResponse>
)

data class LottoResponse(
    val numbers: List<Int>
)
