package lotto.dto

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    override fun toString() = number.toString()

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
