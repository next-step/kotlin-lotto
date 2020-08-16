package lotto

import kotlin.math.floor

class Lotto {
    private val _numbers = mutableListOf<Int>()
    val numbers: List<Int> get() = _numbers

    fun autoLotto(): Set<Int> {
        return (NUMBER_MINIMUM..NUMBER_MAXIMUM).shuffled().take(LOTTO_NUMBER).toSortedSet()
    }

    fun generate(numbers: Set<Int>) {
        require(numbers.size == 6) {

        }
        _numbers.addAll(numbers)
    }

    fun getPrize(userNumber: List<Int>, winningNumber: List<Int>): List<Rank> {
        val counts = Ticket().purchasedLotto.map { lotto ->
            lotto.numbers.count { _number -> winningNumber.contains(_number) }
        }
        return counts.map { count -> Rank.findMatchCount(count) }
    }

    fun getStatistics(price: Int, ranks: List<Rank>): Double {
        val total = ranks.asSequence()
            .map { it.reward }
            .reduce { acc, money -> acc + money }.toDouble()
        return floor(total / price * 100.0) / 100.0
    }

    companion object {
        const val LOTTO_NUMBER = 6
        const val NUMBER_MINIMUM = 1
        const val NUMBER_MAXIMUM = 45
    }
}

fun main() {
    val result = Lotto().apply { generate(autoLotto()) }
    print(result.numbers)
}
