package lotto.domain

@JvmInline
value class PurchaseMoney(val value: Long) {
    init {
        require(value >= 0) { "로또 구입 금액은 최소 0원 이상이어야 합니다." }
    }
}
