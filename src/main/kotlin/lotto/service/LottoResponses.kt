package lotto.service

data class LottoResponses(
    val manualLottos: List<LottoResponse>,
    val autoLottos: List<LottoResponse>
)

data class LottoResponse(
    val numbers: List<Int>
)
