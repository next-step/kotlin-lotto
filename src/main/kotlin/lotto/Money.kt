package lotto

private const val MINIMUM_PRICE = 1000

@JvmInline
value class Money private constructor(val value: Int) {
    init {
        require(value > MINIMUM_PRICE) { "지불 금액은 최소 금액(1000원) 이상이어야 합니다." }
    }

    companion object {
        fun of(value: String?): Money {
            require(!value.isNullOrBlank()) { "지불 금액은 비어있거나 null일 수 없습니다." }
            return Money(value.toInt())
        }

        fun of(value: Int) = Money(value)
    }
}
