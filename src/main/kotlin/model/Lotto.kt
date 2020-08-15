package model

class Lotto(override val number: Set<LottoNumber>, val isManual: Boolean = false) : BasicLotto {
    init {
        require(number.size == 6) { "not accept lotto" }
    }

    fun isIn(value: LottoNumber): Boolean {
        return number.contains(value)
    }

    companion object {
        const val SIZE = 6
        private val allLottoNumberList = IntRange(LottoNumber.MINIMUM_NUMBER, LottoNumber.MAXIMUM_NUMBER)

        fun make(): Lotto {
            val lottoNumberList = allLottoNumberList.shuffled().take(SIZE).map { LottoNumber.from(it) }.toSet()
            return Lotto(lottoNumberList)
        }
    }

    override fun toString(): String {
        return number.map { it.value }.joinToString(prefix = "[", postfix = "]")
    }
}
