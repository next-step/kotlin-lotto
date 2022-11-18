package nextstep.mission.lotto

import kotlin.random.Random

object NumberFactory {
    tailrec fun create(numbers: List<Int> = emptyList()): List<Int> = when (numbers.size) {
        6 -> numbers
        else -> create(numbers + Random.nextInt(1, 45))
    }
}
