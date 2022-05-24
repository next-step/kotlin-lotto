package lotto

import kotlin.random.Random

object LottoCreator {

    fun issue(count: Int): List<List<Int>> {
        val randomIssuedList = mutableListOf<List<Int>>()
        repeat(count) {
            randomIssuedList.add(
                generateSequence { Random(Random.nextInt()).nextInt(LOTTO_NUMBER_RANGE.first, LOTTO_NUMBER_RANGE.last) }
                    .distinct()
                    .take(LOTTO_NUMBER_COUNT)
                    .sorted()
                    .toList()
            )
        }

        return randomIssuedList
    }

    const val LOTTO_NUMBER_COUNT = 6
    val LOTTO_NUMBER_RANGE = (1..45)
}