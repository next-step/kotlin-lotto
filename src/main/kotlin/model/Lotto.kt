package model

class Lotto(override val number: List<LottoNumber>) : BasicLotto {
    init {
        val checkDuplicateNumber = number.groupingBy { it }.eachCount().values.filter { it > 1 }
        require(checkDuplicateNumber.isEmpty()) { "not accept lotto" }
    }

    companion object {
        const val SIZE = 6

        fun make(): Lotto {
            val lottoNumberList = IntRange(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER).shuffled().take(SIZE).map { LottoNumber.from(it) }
            return Lotto(lottoNumberList)
        }
    }
}
