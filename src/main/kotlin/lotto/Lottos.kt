package lotto

class Lottos(private val amountOfLotto: Int) {
    private val lottos = (0 until amountOfLotto).map { Lotto() }

    fun getLottos() = lottos

    fun matchLottos(winningLotto: WinningNumbers): List<Rank> {
        val results = mutableListOf<Rank>()
        lottos.forEach {
            val count = it.matchLotto(winningLotto)
            results.add(Rank.of(count))
        }
        return results.toList()
    }
}
