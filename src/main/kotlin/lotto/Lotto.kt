package lotto

import java.lang.Math.floor

class Lotto {
    fun buyTickets(pay: Int): Int {
        return pay / TICKET_PRICE
    }

    companion object {
        const val TICKET_PRICE = 1000
        const val LOTTO_NUMBER = 6
    }

    fun tickets(totalTickets: Int): List<List<Int>> {
        val sampleTickets = mutableListOf<List<Int>>()
        sampleTickets.add(autoLotto())
        return sampleTickets
    }

    fun autoLotto(): List<Int> {
        return (1..45).shuffled().take(LOTTO_NUMBER).sorted()
    }

    fun match(userLotto: List<Int>, winningLotto: List<Int>): Int {
        return userLotto.count { number -> winningLotto.contains(number) }
    }
    fun result(count:Int): Rank {
        return Rank.findMatchCount(count)
    }
}
class Store(private val buyed: Lotto) {

    fun drawLottoNumber(lastWeekLotto: Lotto): List<Int> =
        buyed.tickets(14).map {ticket -> buyed.match(userLotto = ticket,winningLotto = InputNumber.winningNumberInput()) }

    fun getRateOfReturn(price: Int, prizes: List<Rank>): Double {
        val totalPrize = prizes
            .map { it.reward }
            .reduce { acc, money ->
                acc + money
            }
            .toDouble()

        return floor(totalPrize / price * 100.0) / 100.0
    }
}

enum class Rank(val matchCount: Int, val reward: Int) {
    ALLMATCH(6, 2_000_000_000),
    FIVEMATCH(5, 1_500_000),
    FOURMATCH(4, 50_000),
    THREEMATCH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun findMatchCount(matchCount: Int): Rank {
            return enumValues<Rank>().firstOrNull() { it.matchCount == matchCount } ?: NONE
        }
    }
}

fun main() {
    val lottoTickets = Lotto().tickets(14)
    for (ticket in lottoTickets) {
        println(ticket)
    }
}


