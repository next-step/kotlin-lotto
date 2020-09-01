package lotto.domain.lotto

class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int = value.compareTo(other.value)

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

    override fun toString() = value.toString()

    companion object {
        val NUMBER_RANGE = 1..45
        private val CACHE: Map<Int, LottoNumber> = NUMBER_RANGE.associateWith { LottoNumber(it) }

        fun of(number: Int): LottoNumber = CACHE[number] ?: throw IllegalArgumentException()
    }
}
