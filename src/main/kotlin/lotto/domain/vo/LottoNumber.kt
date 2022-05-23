package lotto.domain.vo

private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER = 45

@JvmInline
value class LottoNumber(private val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in LOTTO_NUMBER_RANGE) { "로또 숫자는 $MIN_LOTTO_NUMBER 부터 $MAX_LOTTO_NUMBER 까지 숫자이어야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int = value - other.value

    override fun toString(): String = value.toString()

    companion object {
        private val LOTTO_NUMBER_RANGE = MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER
    }
}
