package lotto

class LottoSeller(private val money: Money) {

    init {
        validate()
    }

    private fun validate() {
        require(money.get % LOTTO_PRICE == 0) { "최소 단위는 1000원 입니다" }
    }

    fun getLottoCount(): Int {
        return money.divide(LOTTO_PRICE).get
    }

    companion object {
        const val LOTTO_PRICE = 1_000
    }
}
