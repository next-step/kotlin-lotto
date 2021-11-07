package lotto.domain

@JvmInline
value class Money private constructor(
    private val money: Int
) {

    init {
        require(money >= LOTTO_PRICE) { NOT_ENOUGH_MONEY_MESSAGE }
    }

    val lottoCount: Int
        get() = money / LOTTO_PRICE

    companion object {
        const val LOTTO_PRICE = 1000
        const val NOT_ENOUGH_MONEY_MESSAGE = "로또를 하시려면 최소 1000원은 필요합니다."
        const val NUMBER_FORMAT_EXCEPTION_MESSAGE = "금액은 숫자만 입력할 수 있습니다"

        fun of(value: String): Money {
            return Money(value.toIntOrNull() ?: throw IllegalArgumentException(NUMBER_FORMAT_EXCEPTION_MESSAGE))
        }
    }
}
