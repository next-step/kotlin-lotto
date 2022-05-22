package lotto

@JvmInline
value class WinNumbers(val value: List<Int>) {

    fun matchCount(lotto: Lotto): Int = value.count { lotto.numbers.contains(it) }
}
