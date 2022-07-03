package lotto.domain

operator fun LottoMoney.minus(other: LottoMoney): LottoMoney {
    val difference = this.money - other.money
    require(difference > 0) { "구입금액보다 더 많은 수동 로또를 구매하실 수 없습니다" }

    return LottoMoney(difference)
}

operator fun LottoMoney.compareTo(other: LottoMoney) = this.money.compareTo(other.money)

@JvmInline
value class LottoMoney(val money: Int = 0) {
    init {
        require(money >= Lotto.PRICE) {
            "최소 구입금액은 ${Lotto.PRICE}원 입니다."
        }

        require(money % Lotto.PRICE == 0) {
            "${Lotto.PRICE}원 단위로 구매하실 수 있습니다."
        }
    }

    fun calculateLottoCount() = this.money / Lotto.PRICE
}
