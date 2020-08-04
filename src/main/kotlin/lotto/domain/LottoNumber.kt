package lotto.domain

class LottoNumber private constructor(
    private val value: Int
) {

    override fun toString(): String {
        return "$value"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as LottoNumber

        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        return value
    }

    companion object {
        const val MIN_LOTTO_NUMBER = 1
        const val MAX_LOTTO_NUMBER = 45

        fun of(number: Int): LottoNumber {
            validateNumberRange(number)
            return LottoNumberCache.of(number)
        }

        private fun validateNumberRange(number: Int) {
            require(number in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "$number 는 로또 번호(1~45)가 아닙니다." }
        }
    }

    private object LottoNumberCache {
        private val cache = List(MAX_LOTTO_NUMBER) { LottoNumber(it + 1) }

        fun of(number: Int): LottoNumber = cache[number - 1]
    }
}
