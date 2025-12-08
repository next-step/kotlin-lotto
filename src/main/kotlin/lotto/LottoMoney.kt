package lotto

class LottoMoney {
    val price: Int

    companion object {
        const val LOTTO_UNIT_PRICE = 1000
    }

    constructor(price: String?) {
        price
            ?.toUIntOrNull()
            ?: throw IllegalArgumentException("올바른 금액을 입력하세요")

        require(price.toInt() > 0) { "올바른 금액을 입력하세요" }
        require(price.toInt() % LOTTO_UNIT_PRICE == 0) { "${LOTTO_UNIT_PRICE}원 단위로 입력하세요" }

        this.price = price.toInt()
    }
}
