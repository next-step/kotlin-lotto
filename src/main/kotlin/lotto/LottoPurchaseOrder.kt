package lotto

data class LottoPurchaseOrder(
    val totalPurchasePrice: Int,
    val manualLottoNumbers: List<LottoNumbers>,
)
