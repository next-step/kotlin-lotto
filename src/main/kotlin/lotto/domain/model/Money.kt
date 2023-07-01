package lotto.domain.model

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0) { "음수 값이 올 수 없습니다" }
    }
}
