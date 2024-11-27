package lotto.domain.purchase

@JvmInline
value class Amount(val value: Int) {
    init {
        require(value > 0) { AMOUNT_NEGATIVE_EXCEPTION_MESSAGE }
    }

    companion object {
        private const val AMOUNT_NEGATIVE_EXCEPTION_MESSAGE = "수량은 음수가 될 수 없습니다."
    }
}
