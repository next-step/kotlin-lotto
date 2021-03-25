package lotto.utils

import kotlin.random.Random

object NumberUtil {

    fun makeNumbers(maxSize: Int, startNumber: Int, endNumber: Int): List<Int> {
        var set = HashSet<Int>()
        while (set.size < maxSize) {
            set.add(getRandomNumber(startNumber, endNumber))
        }
        return set.sorted()
    }

    fun getRandomNumber(startNumber: Int, endNumber: Int): Int {
        return Random.nextInt(startNumber, endNumber)
    }
}
