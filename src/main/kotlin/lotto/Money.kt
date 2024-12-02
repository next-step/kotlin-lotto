package lotto

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    operator fun minus(other: Money): Money {
        return Money(this.value - other.value)
    }
}
