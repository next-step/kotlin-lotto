package lotto.domain.purchase

private const val LOTTO_PURCHASE_UNIT_MONEY = 1000

class PurchaseMoney(private val money: Long) {
    init {
        require(money >= LOTTO_PURCHASE_UNIT_MONEY) { "최소 구입 금액은 로또 한 장 가격인 ${LOTTO_PURCHASE_UNIT_MONEY}원 입니다."}
    }

    fun getLottoPurchaseCount(): Long {
        return money / LOTTO_PURCHASE_UNIT_MONEY
    }
}