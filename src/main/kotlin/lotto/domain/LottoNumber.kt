package lotto.domain

class LottoNumber private constructor(val number: Int) {
    init {
        require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            "Lotto number should be between $LOTTO_MIN_NUMBER and $LOTTO_MAX_NUMBER"
        }
    }

    override fun toString(): String = number.toString()

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45

        private val cache = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).associateWith { LottoNumber(it) }

        fun of(number: Int): LottoNumber {
            return cache[number] ?: throw IllegalArgumentException("Invalid lotto number: $number")
        }
    }
}
