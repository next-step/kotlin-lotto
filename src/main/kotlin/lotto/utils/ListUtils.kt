package lotto.utils

fun shuffleAndTake(list: List<Int>, n: Int, sort: Boolean = false): List<Int> {
    val shuffled = list
        .shuffled()
        .take(n)

    return if (sort) {
        shuffled.sorted()
    } else {
        shuffled
    }
}
