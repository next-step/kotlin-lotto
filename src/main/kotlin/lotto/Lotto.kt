package lotto

import kotlin.random.Random

class Lotto {
    fun buytickets(pay: Int): Int {
        return pay / TICKETPRICE
    }

    companion object {

        const val TICKETPRICE = 1000
        const val LOTTONUMBER = 6
    }

    fun tickets(totaltickets: Int): Int {
        var samplenumbers: MutableList<Int> = mutableListOf<Int>()
        var sampletickets = mutableListOf(mutableListOf<Any>())
        for (x in 0 until totaltickets) {
            for (i in 0 until LOTTONUMBER) {
                samplenumbers.add(Random.nextInt(1, 45))
            }
            sampletickets.add(samplenumbers.toMutableList())
            samplenumbers.clear()
        }
        sampletickets.removeAt(0)
        return sampletickets.size
    }

    fun match(userLotto: Lotto, winningLotto: WinningLotto): Int {
        val matchCount = match(userLotto, winningLotto)

        return rank(matchCount)
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
