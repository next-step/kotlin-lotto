package lotto



class Lotto {
    private var _numbers = setOf<Int>()
    val numbers: Set<Int> = _numbers

    fun autoLotto(): Set<Int> {
        return (NUMBER_MINIMUM..NUMBER_MAXIMUM).shuffled().sorted().take(LOTTO_NUMBER).toSet()
    }

    fun getPrize(userNumber: List<Int>, winningNumber: List<Int>): List<Rank> {
        val counts = Ticket().purchasedLottootto.map { lotto ->
            lotto.numbers.count { number -> winningNumber.contains(number) }
        }
        return counts.map { count -> Rank.findMatchCount(count) }
    }

    companion object {
        const val LOTTO_NUMBER = 6
        const val NUMBER_MINIMUM = 1
        const val NUMBER_MAXIMUM = 45
    }
}
