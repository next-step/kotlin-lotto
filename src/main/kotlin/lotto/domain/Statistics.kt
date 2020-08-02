package lotto.domain

object Statistics {

    var count_3 = 0
    var count_4 = 0
    var count_5 = 0
    var count_6 = 0

    fun countRank(winningCount: Int) {
        when (winningCount) {
            3 -> count_3++
            4 -> count_4++
            5 -> count_5++
            6 -> count_6++
        }
    }
}
