package lotto.domain

data class Lotto(val numbers: HashSet<LottoNumber>) {
    init {
        require(numbers.size == NUMBER_COUNT)
    }

    companion object {
        const val NUMBER_COUNT = 6
    }
}

data class WinLotto(val numbers: HashSet<LottoNumber>, val bonusNumber: LottoNumber) {
    init {
        require(numbers.size == NUMBER_COUNT)
        require(bonusNumber !in numbers)
    }

    fun getCountOfMatch(otherLotto: Lotto): Int {
        return (numbers intersect otherLotto.numbers.toSet()).size
    }

    fun isBonusNumberIn(otherLotto: Lotto): Boolean = bonusNumber in otherLotto.numbers

    companion object {
        private const val NUMBER_COUNT = 6

        fun create(rawNumbers: List<Int>, bonusRawNumber: Int): WinLotto {
            return WinLotto(rawNumbers.map { rawNumber -> LottoNumber(rawNumber) }.toHashSet(), LottoNumber(bonusRawNumber))
        }
    }
}

data class LottoNumber(val number: Int) {
    init {
        require(number in RANGE)
    }

    override fun toString(): String {
        return number.toString()
    }

    companion object {
        const val MIN_NUMBER = 1
        const val MAX_NUMBER = 45
        val RANGE = MIN_NUMBER..MAX_NUMBER
    }
}

data class LottoStatics(val ranks: Map<LottoRank, Int>, val totalBuyAmount: Int, val totalWinningPrice: Int, val rateOfReturn: Double)
