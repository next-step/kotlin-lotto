package lotto

class LottoSeller(private var money: Money) {

    init {
        validate()
    }

    private fun validate() {
        require(money.won % LOTTO_PRICE == 0) { "최소 단위는 1000원 입니다" }
    }

    fun getLottoCount(): Int {
        return money.divide(LOTTO_PRICE).won
    }

    fun buyManual(count: Int) {
        require(getLottoCount() >= count) {"해당 금액보다 초과된 로또 갯수입니다."}
        this.money = money.minus(count * LOTTO_PRICE)
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
