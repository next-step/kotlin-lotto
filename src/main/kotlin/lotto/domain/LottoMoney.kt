package lotto.domain

@JvmInline
value class LottoMoney(val money: Int = 0) {
    init {
        if (money < Lotto.PRICE) {
            throw IllegalArgumentException("최소 구입금액은 ${Lotto.PRICE}원 입니다.")
        }

        if (money % Lotto.PRICE != 0) {
            throw IllegalArgumentException("${Lotto.PRICE}원 단위로 구매하실 수 있습니다.")
        }
    }

    fun calculateLottoCount() = this.money / Lotto.PRICE
}
