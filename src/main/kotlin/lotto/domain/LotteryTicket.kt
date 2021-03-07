package lotto.domain

class LotteryTicket(val numbers: List<Int>) {
    fun findMatchCount(winningNums: List<Int>): Int {
        return numbers.filter { winningNums.contains(it) }
            .count()
    }
}
