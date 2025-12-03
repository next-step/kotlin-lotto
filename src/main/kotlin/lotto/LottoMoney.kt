package lotto

class LottoMoney {
    val price: Int

    companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }

    constructor(price: String?) {
        if (price.isNullOrBlank()) {
            throw IllegalArgumentException("뭐라도 입력하세요")
        }
        if (!price.matches("^\\d+$".toRegex()) || price.toInt() <= 0) {
            throw IllegalArgumentException("올바른 금액을 입력하세요")
        }
        if (price.toInt() % LOTTO_UNIT_PRICE != 0) {
            throw IllegalArgumentException("${LOTTO_UNIT_PRICE}원 단위로 입력하세요")
        }
        this.price = price.toInt()
    }
}
