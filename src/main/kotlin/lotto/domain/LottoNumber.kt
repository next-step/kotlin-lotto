package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { "로또 번호는 1~45 사이의 숫자만 가능합니다." }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
