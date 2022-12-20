package lotto.domain

class Round(
    private val purchasedLottos: List<Lotto>,
    private val winningLotto: WinningLotto
) {
    fun aggregate(): RoundResult {
        return RoundResult(
            purchasedLottos
                .map { winningLotto.match(it) }
                .groupingBy { it }
                .eachCount()
        )
    }
}