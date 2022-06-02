package lotto

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) {
            throw IllegalArgumentException("로또 번호는 ${LOTTO_NUMBER_RANGE.first}이상, ${LOTTO_NUMBER_RANGE.last} 이하 숫자 입니다 - `$number")
        }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
