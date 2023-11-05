package lotto

enum class LottoWinning(private val correctCount: Int, val reward: Int) {
    Nothing(0, 0),
    CorrectThree(3, 5000),
    CorrectFour(4, 50000),
    CorrectFive(5, 1500000),
    CorrectSix(6, 2000000000);

    companion object {
        fun of(count: Int): LottoWinning {
            val correctCount = count.coerceIn(0..6)

            return LottoWinning.values()
                .firstOrNull { it.correctCount == correctCount }
                ?: Nothing
        }
    }
}
