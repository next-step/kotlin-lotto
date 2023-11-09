package study.lotto.domain

data class LottoNumber(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in START_NUMBER..LAST_NUMBER) {
            "Lotto numbers must be in the range $START_NUMBER to $LAST_NUMBER"
        }
    }

    override fun compareTo(other: LottoNumber): Int = this.number - other.number
    companion object {
        const val START_NUMBER = 1
        const val LAST_NUMBER = 45

        fun getLottoNumbers() = (START_NUMBER..LAST_NUMBER).shuffled().map(::LottoNumber)

        fun listOf(vararg numbers: Int) = numbers.toList().sorted().map(::LottoNumber)
    }
}
