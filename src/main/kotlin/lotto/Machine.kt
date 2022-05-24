package lotto

import kotlin.random.Random

class Machine(val purchasePrice: Int) {
    var lottoCount = 0
        private set

    var lottoList = emptyList<Lotto>()
        private set

    fun purchase() {
        lottoCount = purchasePrice / 1000
        lottoList = (1..lottoCount).toList().map { Lotto(makeRandomNumbers()) }
    }


    private fun makeRandomNumbers(): Set<Int> {
        val list = mutableListOf<Int>()
        while (list.size < 6) {
            val random = Random.nextInt(1, 45)
            if (!list.contains(random)) {
                list.add(random)
            }
        }
        return list.toSet()
    }

    private fun winningPrice(confirmation: Confirmation): Int {
        return when (confirmation.winningNumbers.size) {
            3 -> 5000
            4 -> 50000
            5 -> 1500000
            6 -> 2000000000
            else -> 0
        }

    }
}
