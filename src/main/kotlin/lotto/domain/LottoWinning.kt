package lotto.domain

enum class LottoWinning(val correctCount: Int, val reward: Int) {
    Nothing(0, 0),
    CorrectThree(3, 5_000),
    CorrectFour(4, 50_000),
    CorrectFive(5, 1_500_000),
    CorrectSix(6, 2_000_000_000);

    companion object {
        fun of(correctCount: Int): LottoWinning {
            require(correctCount in 0..6) {
                "당첨 번호 수는 0에서 6사이여야 합니다."
            }

            return LottoWinning.values()
                .firstOrNull { it.correctCount == correctCount }
                ?: Nothing
        }
    }
}
