package lotto

class Money(val price: Int) {
    init {
        require(price > 0) { ERROR_MESSAGE_INVALID }
    }

    companion object {
        private const val MIN_PRICE = 1
        private const val ERROR_MESSAGE_EMPTY = "뭐라도 입력하세요"
        private const val ERROR_MESSAGE_INVALID = "올바른 금액을 입력하세요"

        operator fun invoke(price: String?): Money {
            requireNotNull(price) { ERROR_MESSAGE_EMPTY }
            require(price.isNotBlank()) { ERROR_MESSAGE_EMPTY }

            val priceInt = price.toIntOrNull() ?: throw IllegalArgumentException(ERROR_MESSAGE_INVALID)

            require(priceInt >= MIN_PRICE) { ERROR_MESSAGE_INVALID }

            return Money(priceInt)
        }
    }
}
