package stringAddCalculator

internal fun sumBy(ints: List<Int>): Int = ints.reduce { acc: Int, i: Int -> acc + i }
