package lotto.domain

data class LottoNumber(private val number: Int) {
    fun getNumber() = number

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
        private val LOTTO_NUMBER_POOL = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            return LOTTO_NUMBER_POOL[number] ?: throw IllegalArgumentException("로또 번호는 1보다 적거나 45보다 클 수 없습니다")
        }

        fun from(number: String): LottoNumber {
            return from(number.toIntOrNull() ?: throw IllegalArgumentException("유효하지 않은 번호입니다"))
        }
    }
}
