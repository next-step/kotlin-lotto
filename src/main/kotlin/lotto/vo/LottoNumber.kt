package lotto.vo

@JvmInline
value class LottoNumber private constructor(
    private val value: Int,
) : Comparable<LottoNumber> {

    override fun compareTo(other: LottoNumber): Int {
        return value - other.value
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        private val LOTTO_NUMBERS = (1..45).associateBy({ it }, ::LottoNumber)

        fun from(number: Int): LottoNumber {
            return LOTTO_NUMBERS[number] ?: throw IllegalArgumentException("로또 번호는 1~45 사이의 숫자여야 합니다.")
        }
    }
}
