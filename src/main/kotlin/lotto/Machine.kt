package lotto

import kotlin.random.Random

class Machine(val price: Int) {
    val lottoCount = price / 1000

    val lottoList = (1..lottoCount).toList().map {
        Lotto(makeRandomNumbers())
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
}
