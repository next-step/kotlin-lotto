package lotto.domain

class LottoNumber private constructor(
    val value: Int,
) : Comparable<LottoNumber> {
    override fun compareTo(other: LottoNumber): Int = value compareTo other.value

    companion object {
        private const val MIN_VALUE = 1
        private const val MAX_VALUE = 45
        val RANGE = MIN_VALUE..MAX_VALUE
        private val NUMBERS: Map<Int, LottoNumber> = RANGE.associateWith { LottoNumber(it) }

        fun from(value: Int): LottoNumber = NUMBERS[value] ?: throw IllegalArgumentException("로또 번호는 ${MIN_VALUE}부터 ${MAX_VALUE}까지 가능합니다.")
    }
}
