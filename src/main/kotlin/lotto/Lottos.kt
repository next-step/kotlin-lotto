package lotto

class Lottos(private val amountOfLotto: Int) {
    private val lottos = (0 until amountOfLotto).map { Lotto() }

    fun getLottos() = lottos

    fun matchLottos(winningLotto: WinningNumbers, bonusBall: Int): List<Rank> {
        val results = mutableListOf<Rank>()
        lottos.forEach {
            val count = it.matchLotto(winningLotto)
            val bonusBallResult = it.matchBonusBall(bonusBall)
            results.add(Rank.of(count, bonusBallResult))
        }
        return results.toList()
    }
}
