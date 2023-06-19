package lotto.entity

enum class Rank(val countOfMatch: Int, val prize: Long) {
    First(countOfMatch = 6, prize = 2_000_000_000L),
    Second(countOfMatch = 6, prize = 1_500_000L),
    Third(countOfMatch = 5, prize = 50_000L),
    Fourth(countOfMatch = 3, prize = 5_000L),
    None(countOfMatch = 0, prize = 0L), ;

    companion object {
        fun whatRank(lotto: Lotto, winningNumbers: Set<LottoNumber>, bonusBall: LottoNumber): Rank {
            return when ((winningNumbers + bonusBall).count { lotto.numbers.contains(it) }) {
                Fourth.countOfMatch -> Fourth
                Third.countOfMatch -> Third
                First.countOfMatch -> determineFirstOrSecond(lotto, bonusBall)
                else -> None
            }
        }

        private fun determineFirstOrSecond(lotto: Lotto, bonusBall: LottoNumber): Rank =
            if (lotto.numbers.contains(bonusBall)) {
                Second
            } else {
                First
            }
    }
}
