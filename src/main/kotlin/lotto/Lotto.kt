package lotto

class Lotto {
    private val _numbers = mutableListOf<Int>()
    private val _sampleTest: List<Int> = listOf(1, 2, 3, 4, 5, 7)
    val numbers: List<Int> get() = _numbers

    fun autoLotto(): Set<Int> {
        return (NUMBER_MINIMUM..NUMBER_MAXIMUM).shuffled().take(LOTTO_NUMBER).toSortedSet()
    }

    fun validateSize(numbers: Set<Int>) {
        require(numbers.size == 6) {
            "로또 숫자는 6개 입니다."
        }
    }

    fun generate(numbers: Set<Int>) {
        validateSize(numbers)
        _numbers.addAll(numbers)
    }

    fun getPrizeWithBonus(winningNumber: List<Int>, bonusNumber: Int): Rank {
        val counts = this._numbers.count { number -> winningNumber.contains(number) }
        // val counts = this._sampleTest.count { number -> winningNumber.contains(number) }

        val bonusCheck = this.numbers.contains(bonusNumber)
        // val bonusCount = this._sampleTest.contains(bonusNumber)

        return Rank.valueOf(counts, bonusCheck)
    }

    companion object {

        const val LOTTO_NUMBER = 6
        const val NUMBER_MINIMUM = 1
        const val NUMBER_MAXIMUM = 45
    }
}
