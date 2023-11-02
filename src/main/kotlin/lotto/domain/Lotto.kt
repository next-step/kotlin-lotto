package lotto.domain

@JvmInline
value class Lotto(val numbers: List<Int>) {
    fun matchCount(winningLotto: Lotto): Int {
        return numbers.filter { winningLotto.numbers.contains(it) }.size
    }
}
