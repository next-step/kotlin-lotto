package lotto.domain

data class LottoNumber private constructor(val value: Int) : Comparable<LottoNumber> {

    init {
        require(value in RANGE) { "로또 넘버의 범위는 $MINIMUM_VALUE ~ $MAXIMUM_VALUE 입니다. 입력 값: $value" }
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }

    companion object {
        private const val MINIMUM_VALUE = 1
        private const val MAXIMUM_VALUE = 45
        val RANGE = (MINIMUM_VALUE..MAXIMUM_VALUE)
        private val NUMBERS = RANGE.map { LottoNumber(it) }

        fun of(value: Int): LottoNumber {
            return NUMBERS[value - 1]
        }
    }
}
