package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) {
            "로또 번호는 ${LOTTO_NUMBER_RANGE.first}부터 ${LOTTO_NUMBER_RANGE.last}까지 입니다."
        }
    }

    companion object {
        private val LOTTO_NUMBER_RANGE = 1..45
    }
}
