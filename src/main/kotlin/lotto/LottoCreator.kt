package lotto

import kotlin.random.Random

object LottoCreator {

    fun issue(count: Int): List<List<Int>> {
        require(count > 0)

        val randomIssuedList = (1..count).map {
            randomNumbers()
        }

        return randomIssuedList
    }

    val randomNumbers = {
        generateSequence { Random(Random.nextInt()).nextInt(LOTTO_NUMBER_RANGE.first, LOTTO_NUMBER_RANGE.last) }
            .distinct()
            .take(LOTTO_NUMBER_COUNT)
            .sorted()
            .toList()
    }

    private const val LOTTO_NUMBER_COUNT = 6
    private val LOTTO_NUMBER_RANGE = (1..45)
}
