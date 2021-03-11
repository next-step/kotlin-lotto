package lotto

import kotlin.random.Random

class Lotto(private val startNumber: Int, private val endNumber: Int, private val maxCount: Int) {

    fun issue(): LottoData {
        return LottoData(makeNumbers())
    }

    private fun makeNumbers(): List<Int> {
        var set = HashSet<Int>()
        while (set.size < maxCount) {
            set.add(getRandomNumber())
        }
        return set.sorted()
    }

    private fun getRandomNumber(): Int {
        return Random.nextInt(startNumber, endNumber)
    }
}
