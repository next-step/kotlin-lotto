package lotto.domain

@JvmInline
value class LottoNumber private constructor(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45

        private val CACHE = (LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX).map { LottoNumber(it) }

        fun from(number: Int): LottoNumber {
            require(number in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { "로또 번호는 1부터 45 사이여야 합니다." }
            return CACHE[number - 1]
        }
    }
}
