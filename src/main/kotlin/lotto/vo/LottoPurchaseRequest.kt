package lotto.vo

data class LottoPurchaseRequest(
    val allBudget: Int,
    val priceOfLotto: Int,
    val manualLottosNumbers: List<List<Int>>
)
