package lotto.model.input

data class Money(val value: Int) {
    init {
        require(value >= ZERO) { "로또 구매 금액은 0원보다 커야 합니다." }
    }

    constructor(input: String) : this(input.toInt())

    fun getBuyableLottoCount(): Int {
        return value / ONE_LOTTO_PRICE
    }

    companion object {
        private const val ONE_LOTTO_PRICE = 1000
        private const val ZERO = 0
    }
}
