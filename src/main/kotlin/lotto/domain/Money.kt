package lotto.domain

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= MIN_PRICE) { "로또는 최소 1,000원부터 구매가능합니다." }
        require(value <= MAX_PRICE) { "한번에 구매 가능한 최대 금액은 100,000원입니다." }
    }

    fun countLotto(): Int {
        return value / MIN_PRICE
    }

    fun countAutoLotto(countManualLotto: Int): Int {
        return countLotto() - countManualLotto
    }

    companion object {
        private const val MIN_PRICE = 1000
        private const val MAX_PRICE = 100000
    }
}
