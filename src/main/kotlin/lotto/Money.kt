package lotto

@JvmInline
value class Money(val value: Int) {
    init {
        require(value >= 0) { "음수는 입력할 수 없습니다." }
    }

    fun minus(value: Int): Money {
        return Money(this.value - value)
    }
}
