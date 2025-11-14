package lotto

class Money {
    val price: Int

    constructor(price: String?) {
        if (price.isNullOrBlank()) {
            throw IllegalArgumentException("뭐라도 입력하세요")
        }
        if (!price.matches("^\\d+$".toRegex()) || price.toInt() <= 0) {
            throw IllegalArgumentException("올바른 금액을 입력하세요")
        }
        this.price = price.toInt()
    }
}
