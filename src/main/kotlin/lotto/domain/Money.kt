package lotto.domain

class Money(val price: Int) {
    init {
        require(price >= MIN_PRICE) { ERROR_MESSAGE_INVALID }
    }

    companion object {
        private const val MIN_PRICE = 0
        private const val ERROR_MESSAGE_INVALID = "금액은 0 혹은 양수여야합니다."
    }
}
