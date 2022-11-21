package nextstep.mission.lotto

import kotlin.random.Random

object NumberFactory {

    fun create(): List<Int> {
        tailrec fun create(numbers: List<Int>): List<Int> = when (numbers.size) {
            6 -> numbers
            else -> create(numbers + Random.nextInt(1, 45))
        }
        return create(emptyList())
    }
}
