package lotto.view

class Input(private val amount: Int) {
    val lottoCount: Int
        get() = amount / PER_LOTTO_PRICE

    init {
        require(amount >= PER_LOTTO_PRICE)
    }

    companion object {
        const val PER_LOTTO_PRICE = 1000
    }
}
