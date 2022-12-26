package lotto.domain

class Round(
    private val purchasedLottos: Lottos,
    private val winningLotto: WinningLotto
) {
    fun aggregate(): RoundResult {
        return RoundResult(
            purchasedLottos.match(winningLotto)
                .groupingBy { it }
                .eachCount()
        )
    }
}