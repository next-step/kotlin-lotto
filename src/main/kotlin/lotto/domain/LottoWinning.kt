package lotto.domain

enum class LottoWinning(val countOfMatch: Int, val reward: Int) {
    First(6, 2_000_000_000),
    Second(5, 30_000_000),
    Third(5, 1_500_000),
    Fourth(4, 50_000),
    Fifth(3, 5_000),
    Miss(0, 0);

    companion object {
        fun of(countOfMatch: Int, matchBonus: Boolean): LottoWinning {
            require(countOfMatch in 0..6) {
                "당첨 번호 수는 0에서 6사이여야 합니다."
            }

            if (countOfMatch == 5 && matchBonus) {
                return Second
            }

            return LottoWinning.values()
                .filterNot { it == Second }
                .firstOrNull { it.countOfMatch == countOfMatch }
                ?: Miss
        }
    }
}
