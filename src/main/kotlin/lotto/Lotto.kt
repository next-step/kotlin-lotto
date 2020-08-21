package lotto

class Lotto {
    private val _numbers = mutableListOf<Int>()
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

    fun getPrizeTest(userNumber: List<Int>, winningNumber: List<Int>): Rank {
        return Rank.findMatchCount(userNumber.count { number -> winningNumber.contains(number) })
    }

    fun getPrize(winningNumber: List<Int>): Rank {
        return Rank.findMatchCount(this._numbers.count { number -> winningNumber.contains(number) })
    }

    companion object {

        const val LOTTO_NUMBER = 6
        const val NUMBER_MINIMUM = 1
        const val NUMBER_MAXIMUM = 45
    }
}
