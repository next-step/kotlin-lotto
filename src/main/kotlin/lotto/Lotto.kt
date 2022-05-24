package lotto

import kotlin.random.Random

class Lotto {
    val numbers: List<Int> = makeRandomNumbers()

    private fun makeRandomNumbers(): List<Int> {
        val list = mutableListOf<Int>()

        while (list.size < 6) {
            val random = Random.nextInt(1, 45)
            if (!list.contains(random)) {
                list.add(random)
            }
        }

        return list.toList()
    }
}
