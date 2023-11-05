package lotto.controller

class EndLottoResponse(
    val earningRate: Double
) {
    fun isLoss(): Boolean = earningRate < 1
}
