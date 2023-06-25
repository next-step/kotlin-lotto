package lotto.domain

class Price(buyPrice: String) {
    var value = 0
        private set

    init {
        require(buyPrice.chars().allMatch(Character::isDigit)) { throw IllegalArgumentException("입력한 문자열이 숫자가 아닙니다.") }
        val price = buyPrice.toInt()
        require(price.rem(BUY_PRICE_UNIT) == ZERO) { throw IllegalArgumentException("구매금액은 ${BUY_PRICE_UNIT}원 단위로 입력 가능합니다.") }

        value = price
    }

    companion object {
        private const val ZERO = 0
        private const val BUY_PRICE_UNIT = 1000;
    }
}
