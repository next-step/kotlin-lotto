package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {
    init {
        require(value in 1..45) { "로또 번호는 1부터 45 사이여야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }

    override fun toString(): String {
        return value.toString()
    }
}
