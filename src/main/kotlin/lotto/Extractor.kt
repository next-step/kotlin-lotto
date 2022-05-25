package lotto

import kotlin.random.Random

/**
 * 로또 번호 추출기
 */
object Extractor {
    private const val MAX_LOTTO_COUNT = 6
    private const val MIN_LOTTO_NUMBER = 1
    private const val MAX_LOTTO_NUMBER = 45

    fun getAutoNumbers(): List<Int> {
        val list = mutableListOf<Int>()
        while (list.size < MAX_LOTTO_COUNT) {
            val random = Random.nextInt(MIN_LOTTO_NUMBER, MAX_LOTTO_NUMBER)

            if (!list.contains(random)) {
                list.add(random)
            }
        }
        return list.toList().sorted()
    }
}
