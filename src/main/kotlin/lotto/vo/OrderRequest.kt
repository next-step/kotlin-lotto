package lotto.vo

data class OrderRequest(
    val allBudget: Int,
    val priceOfLotto: Int,
    val manualLottosNumbers: List<List<Int>>
)
