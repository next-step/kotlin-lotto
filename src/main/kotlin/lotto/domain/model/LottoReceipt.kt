package lotto.domain.model

data class LottoReceipt(
    val manualLottoCount: PurchaseCount,
    val automaticLottoCount: PurchaseCount,
    val lottos: Lottos
) {
    operator fun plus(other: LottoReceipt): LottoReceipt {
        return LottoReceipt(
            manualLottoCount + other.manualLottoCount,
            automaticLottoCount + other.automaticLottoCount,
            lottos + other.lottos
        )
    }
}
