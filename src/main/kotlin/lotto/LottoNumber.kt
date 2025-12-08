package lotto

data class LottoNumber(val number: Int) {
    init {
        require(number in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) {
            "${MINIMUM_LOTTO_NUMBER}부터 ${MAXIMUM_LOTTO_NUMBER}까지의 숫자를 입력하세요"
        }
    }

    companion object {
        const val MINIMUM_LOTTO_NUMBER = 1
        const val MAXIMUM_LOTTO_NUMBER = 45
    }
}
