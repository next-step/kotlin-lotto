package lotto.domain

data class Lotto(val numbers: Set<LottoNumber>) {
    init {
        require(numbers.size == NUMBER_COUNT)
    }

    constructor(numbers: List<Int>) : this(numbers.toSet().map { LottoNumber(it) }.toSet())

    companion object {
        const val NUMBER_COUNT = 6
    }
}

data class WinLotto(val lotto: Lotto, val bonusNumber: LottoNumber) {

    constructor(rawNumbers: List<Int>, bonusRawNumber: Int) : this(Lotto(rawNumbers), LottoNumber(bonusRawNumber))

    fun getCountOfMatch(otherLotto: Lotto): Int {
        return (lotto.numbers intersect otherLotto.numbers.toSet()).size
    }

    fun isBonusNumberIn(otherLotto: Lotto): Boolean = bonusNumber in otherLotto.numbers
}

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in RANGE)
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        private const val MIN_NUMBER: Int = 1
        private const val MAX_NUMBER: Int = 45
        val RANGE: IntRange = (MIN_NUMBER..MAX_NUMBER)
    }
}

data class LottoStatics(val ranks: Map<LottoRank, Int>, val totalBuyAmount: Int, val totalWinningPrice: Int, val rateOfReturn: Double)
