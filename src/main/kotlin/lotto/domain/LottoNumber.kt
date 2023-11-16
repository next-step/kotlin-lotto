package lotto.domain

@JvmInline
value class LottoNumber private constructor(val number: Int) {
    init {
        require(number in MIN_NUMBER..MAX_NUMBER) { ERROR_MSG }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val ERROR_MSG = "로또 번호는 1~45 사이의 숫자여야 합니다."
        val NUMBERS: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER).associateWith { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            return NUMBERS[number] ?: throw IllegalArgumentException(ERROR_MSG)
        }
    }
}
