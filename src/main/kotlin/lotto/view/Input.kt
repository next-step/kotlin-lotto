package lotto.view

class Input(val amount: Int) {
    init {
        require(amount >= PER_LOTTO_PRICE)
    }

    companion object {
        const val PER_LOTTO_PRICE = 1000
    }
}
