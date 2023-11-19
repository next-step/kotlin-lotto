package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { ERROR_MESSAGE }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val ERROR_MESSAGE: String = "로또 번호는 45를 넘을 수 없습니다."
        private const val MIN_LOTTO_NUMBER = 1
        private const val MAX_LOTTO_NUMBER = 45
    }
}
