package lotto.domain.model

data class LottoReceipt(
    val manualLottoCount: PurchaseCount,
    val automaticLottoCount: PurchaseCount,
    val lottos: Lottos,
    val changes: Money
)
