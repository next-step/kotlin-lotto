package lotto.business

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) {
            "로또 번호는 $LOTTO_NUMBER_MIN~$LOTTO_NUMBER_MAX 사이의 숫자여야 합니다."
        }
    }

    companion object {
        private const val LOTTO_NUMBER_MIN = 1
        private const val LOTTO_NUMBER_MAX = 45
    }
}
