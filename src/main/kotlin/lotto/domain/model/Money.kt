package lotto.domain.model

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0)
    }
}
