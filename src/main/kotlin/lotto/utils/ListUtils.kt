package lotto.utils

fun <T : Comparable<T>> List<T>.shuffleAndTake(n: Int, sort: Boolean = false): List<T> {
    val shuffled = shuffled().take(n)

    return if (sort) { shuffled.sorted() } else { shuffled }
}
