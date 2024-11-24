package lotto

class BoughtLotto (
    private val lottos: List<Lotto>,
    private val winningLotto: WinningLotto,
) {
    fun matchResult(): Map<Reward, Int> {
        return lottos
            .map { winningLotto.match(it) }
            .groupingBy { it }
            .eachCount()
    }
}
