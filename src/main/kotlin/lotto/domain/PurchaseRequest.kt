package lotto.domain

data class PurchaseRequest(
    val money: Money,
    val manualLottos: List<Lotto> = emptyList(),
) {

    init {
        require(manualLottos.all { it.isManual }) { "수동 로또만 포함해야 합나다." }
    }
}
