package lotto.domain

@JvmInline
value class Lotto(val value: List<Int>) {

    fun findWinningCount(winningLotto: WinningLotto): Int {
        return value.count { winningLotto.winningNumbers.contains(it) }
    }
}
