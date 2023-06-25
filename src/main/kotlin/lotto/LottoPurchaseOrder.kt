package lotto

data class LottoPurchaseOrder(
    val totalPurchasePrice: Int,
    val manualLottoNumbers: List<List<LottoNumber>>,
)
