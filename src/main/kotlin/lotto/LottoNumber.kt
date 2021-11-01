package lotto

private val VALID_LOTTO_RANGE = 1..45

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {

    init {
        require(value in VALID_LOTTO_RANGE) { "로또 번호는 1~45 사이입니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return compareValues(value, other.value)
    }
}
