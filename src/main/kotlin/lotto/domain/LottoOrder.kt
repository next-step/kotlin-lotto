package lotto.domain

data class LottoOrder(
    val money: Money,
    val manualCount: Int = 0,
    val manualLottoNumbers: List<List<Int>> = emptyList(),
) {
    init {
        require(money.value >= 0) { "금액은 0 이상이어야 합니다." }
        require(manualCount == manualLottoNumbers.size) { "수동 로또 개수와 수동 로또 번호의 개수가 일치해야 합니다." }
        require(manualCount * LOTTO_PRICE <= money.value) { "금액이 부족합니다." }
    }

    val remainingQuantity: Int
        get() = getRemainingMoney().value / LOTTO_PRICE

    private fun getRemainingMoney(): Money = Money(money.value - LOTTO_PRICE * manualCount)
}
