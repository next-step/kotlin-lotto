package lotto.domain

data class LottoOrder(
    val money: Money,
    val manualCount: Int = 0,
    val manualLottoNumbers: List<List<Int>> = emptyList(),
) {
    init {
        require(manualCount == manualLottoNumbers.size) { "수동 로또 개수와 수동 로또 번호의 개수가 일치해야 합니다." }
        require(manualCount * LOTTO_PRICE <= money.value) { "금액이 부족합니다." }
    }

    val autoLottoQuantity: Int
        get() = getRemainingMoney().value / LOTTO_PRICE

    private fun getRemainingMoney(): Money = Money(money.value - LOTTO_PRICE * manualCount)
}
