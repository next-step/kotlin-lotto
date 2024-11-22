package lotto.domain

class WinningLotto(private val winningNumbers: Set<Int>) {
    init {
        require(winningNumbers.size == 6) { "당첨 번호는 반드시 6개여야 합니다." }
        require(winningNumbers.all { it in 1..45 }) { "당첨 번호는 1부터 45 사이여야 합니다." }
    }

    fun getRank(lotto: Lotto): Rank {
        val matchCount = lotto.numbers.intersect(winningNumbers).size
        return Rank.from(matchCount) ?: Rank.MISS
    }
}
