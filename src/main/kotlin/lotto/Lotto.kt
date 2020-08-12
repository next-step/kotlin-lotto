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
        repeat(totalTickets) {
            sampleTickets.add(autoLotto())
        }
        return sampleTickets
    }

    fun autoLotto(): List<Int> {
        return (1..45).shuffled().take(LOTTO_NUMBER).sorted()
    }

    fun match(userLotto: List<Int>, winningLotto: List<Int>): Int {
        return userLotto.count { number -> winningLotto.contains(number) }
    }

    fun result(count: Int): Rank {
        return Rank.findMatchCount(count)
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
    val Money = InputNumber.buy()
    val buyTicket = Lotto().buyTickets(Money)
    val lottoTickets = Lotto().tickets(buyTicket)
    ResultView.printBuyedLottoTicket(lottoTickets)
    InputNumber.winningNumberInput()
}
