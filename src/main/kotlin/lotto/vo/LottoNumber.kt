package lotto.vo

@JvmInline
value class LottoNumber(private val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in LottoLowerBound..LottoUpperBound) { "로또 번호는 1~45 사이의 숫자여야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number.compareTo(other.number)
    }

    companion object {
        const val LottoLowerBound = 1
        const val LottoUpperBound = 45
    }
}
