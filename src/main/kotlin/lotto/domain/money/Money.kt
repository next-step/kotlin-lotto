package lotto.domain.money

const val LOTTO_PRICE = 1_000L

@JvmInline
value class PaidMoney(val money: Long) {
    init {
        require(money >= LOTTO_PRICE) { "구입가능한 로또가 없어요. 1000원 이상의 금액만 입력해주세요." }
        require(money % LOTTO_PRICE == 0L) { "1000원 단위로 입력해주세요." }
    }
}

@JvmInline
value class EarnedMoney(val money: Long) {
    init {
        require(money >= 0L) { "금액은 항상 0이상이에요. given money: $money" }
    }
}
