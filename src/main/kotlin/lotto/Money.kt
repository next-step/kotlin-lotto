package lotto

@JvmInline
value class Money(val value: Int) {
    init {
        require(value % 1000 == 0) { "금액은 1000원 단위여야 합니다." }
    }
}
