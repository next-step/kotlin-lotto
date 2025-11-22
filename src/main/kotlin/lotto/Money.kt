package lotto

class Money(val price: Int) {
    init {
        require(price >= MIN_PRICE) { ERROR_MESSAGE_INVALID }
    }

    constructor(price: String?) : this(parseAndValidate(price))

    companion object {
        private const val MIN_PRICE = 1
        private const val ERROR_MESSAGE_EMPTY = "뭐라도 입력하세요"
        private const val ERROR_MESSAGE_INVALID = "올바른 금액을 입력하세요"

        private fun parseAndValidate(price: String?): Int {
            requireNotNull(price) { ERROR_MESSAGE_EMPTY }
            require(price.isNotBlank()) { ERROR_MESSAGE_EMPTY }
            return requireNotNull(price.toIntOrNull()) { ERROR_MESSAGE_INVALID }
        }
    }
}
