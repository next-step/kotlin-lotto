package lotto.domain

enum class LottoWinning(val correctCount: Int, val reward: Int) {
    Nothing(0, 0),
    CorrectThree(3, 5_000),
    CorrectFour(4, 50_000),
    CorrectFive(5, 1_500_000),
    CorrectSix(6, 2_000_000_000);

    companion object {
        fun of(count: Int): LottoWinning {
            val correctCount = count.coerceIn(0..6)

            return LottoWinning.values()
                .firstOrNull { it.correctCount == correctCount }
                ?: Nothing
        }
    }
}
