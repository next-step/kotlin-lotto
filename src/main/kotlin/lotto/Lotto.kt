package lotto

class Lotto {
    fun buyTickets(pay: Int): Int {
        return pay / TICKETPRICE
    }

    companion object {

        const val TICKETPRICE = 1000
    }

    fun tickets(totalTickets: Int): MutableList<MutableList<Any>> {

        val sampleTickets = mutableListOf(mutableListOf<Any>())
        for (x in 0 until totalTickets) {
            sampleTickets.add((1..45).shuffled().take(6).sorted().toMutableList())
        }
        sampleTickets.removeAt(0)
        return sampleTickets
    }

    fun match(userLotto: Array<Int>, winningLotto: Array<Int>): Int {
        val matchCount = userLotto.filter { number -> winningLotto.contains(number) }
        return rank(matchCount.size)
    }

    private fun rank(matchCount: Int): Int {
        if (matchCount == 6) {
            return 1
        }
        if (matchCount == 5) {
            return 2
        }
        if (matchCount > 2) {
            return 6 - matchCount + 2
        }
        return 0
    }
}

fun main() {
    val lottoTickets = Lotto().tickets(14)
    for (ticket in lottoTickets) {
        println(ticket)
    }
}
