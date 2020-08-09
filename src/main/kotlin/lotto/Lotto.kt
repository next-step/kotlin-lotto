package lotto

class Lotto {
    fun buytickets(pay: Int): Int {
        return pay / TICKETPRICE
    }

    companion object {

        const val TICKETPRICE = 1000
    }

    fun tickets(totaltickets: Int): MutableList<MutableList<Any>> {

        val sampletickets = mutableListOf(mutableListOf<Any>())
        for (x in 0 until totaltickets) {
            sampletickets.add((1..45).shuffled().take(6).sorted().toMutableList())
        }
        sampletickets.removeAt(0)
        return sampletickets
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
