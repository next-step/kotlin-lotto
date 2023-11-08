package autolotto.vo

import autolotto.winningpoint.WinningRank

class Lotto(private val originNumbers: List<Int> = listOf()) {
    val numbers: List<Int> = originNumbers.takeIf { it.isNotEmpty() } ?: generateLottoNumbers()

    private fun generateLottoNumbers(): List<Int> {
        return (1..45).shuffled().take(6).sorted()
    }

    fun checkWinning(winningNumbers: List<Int>): WinningRank {
        val matchCount = numbers.intersect(winningNumbers.toSet()).size
        return WinningRank.of(matchCount)
    }
}
