package lotto.domain

data class Price(val value: Int?) {
    init {
        require(value != null) { "로또 금액은 숫자를 입력해야합니다." }
        require(isValidPrice(value)) { "잘못된 금액입니다. value=$value" }
    }

    private fun isValidPrice(price: Int): Boolean {
        return price >= MIN_PRICE && price.mod(LottoNumbers.LOTTO_PRICE) == 0
    }

    companion object {
        private const val MIN_PRICE = 0
    }
}
