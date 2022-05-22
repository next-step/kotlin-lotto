package lotto

@JvmInline
value class WinNumbers(val value: List<Int>) {

    init {
        require(value.toSet().size == value.size) { "중복된 숫자가 있습니다" }
    }

    fun matchCount(lotto: Lotto): Int = value.count { lotto.numbers.contains(it) }
}
