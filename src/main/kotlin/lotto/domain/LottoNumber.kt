package lotto.domain

class LottoNumber private constructor(private val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in MINIMUM_VALUE..MAXIMUM_VALUE)
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number - other.number
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        const val MINIMUM_VALUE = 1
        const val MAXIMUM_VALUE = 45

        private val lottoNumbers: MutableMap<Int, LottoNumber> = mutableMapOf()

        fun from(number: Int): LottoNumber {
            require(number in MINIMUM_VALUE..MAXIMUM_VALUE)
            if (lottoNumbers.containsKey(number)) {
                return lottoNumbers[number]!!
            }

            val lottoNumber = LottoNumber(number)
            lottoNumbers[number] = lottoNumber

            return lottoNumber
        }
    }
}
