package lotto

class WinningBoard(private val winningResults: List<WinningResult>) {
    fun getWinningCount(winningResult: WinningResult): Int = winningResults.count { it == winningResult }
}
