package lotto.exception

class InvalidLottoPriceException : IllegalArgumentException(INVALID_LOTTO_PRICE_MESSAGE) {
    companion object {
        private const val INVALID_LOTTO_PRICE_MESSAGE = "로또는 1000원 단위로 구매할 수 있습니다. 다시 입력해주세요."
    }
}
