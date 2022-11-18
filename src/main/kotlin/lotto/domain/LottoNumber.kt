package lotto.domain

class LottoNumber private constructor(number: Int) : Comparable<LottoNumber> {
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

        private val lottoNumbers: MutableMap<Int, LottoNumber> = init()

        fun from(number: Int): LottoNumber {
            require(number in MINIMUM_VALUE..MAXIMUM_VALUE)
            return lottoNumbers[number]!!
        }

        private fun init(): MutableMap<Int, LottoNumber> {
            val mutableMap = mutableMapOf<Int, LottoNumber>()
            (MINIMUM_VALUE..MAXIMUM_VALUE).forEach { mutableMap[it] = LottoNumber(it) }
            return mutableMap
        }
    }
}
