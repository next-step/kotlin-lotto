package lotto.model

enum class LottoRank(
    val winnings: Int,
    val match: Int
) {
    First(2_000_000_000, 6),
    Second(30_000_000, 5),
    Third(1_5000_000, 5),
    Fourth(50_000, 4),
    Fifth(5_000, 3);

    companion object {
        fun valueOf(match: Int, bonus: Boolean): LottoRank? = when (match) {
            First.match -> First
            Second.match -> if (bonus) Second else Third
            Fourth.match -> Fourth
            Fifth.match -> Fifth
            else -> null
        }
    }
}
