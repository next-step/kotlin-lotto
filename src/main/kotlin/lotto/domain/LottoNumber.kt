package lotto.domain

class LottoNumber(number: Int) : Comparable<LottoNumber> {
    private val number: Int

    init {
        require(number in MINIMUM_VALUE..MAXIMUM_VALUE)
        this.number = number
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number - other.number
    }

    companion object {
        const val MINIMUM_VALUE = 1
        const val MAXIMUM_VALUE = 45
    }
}
