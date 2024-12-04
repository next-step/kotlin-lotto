package lotto.domain

@JvmInline
value class BoughtMoney(
    val value: Int,
) {
    init {
        require(this.value >= 0) { "구입 금액은 유효한 양수로 입력해야합니다." }
    }

    fun calculateAutoLottoAmount(manualLottoAmount: ManualLottoAmount): Int =
        value / LOTTO_PRICE - manualLottoAmount.value
}