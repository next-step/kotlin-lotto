package lotto.application

data class BuyLottoCommand(
    val payment: Long,
    val manualLotto: List<List<Int>>,
)
