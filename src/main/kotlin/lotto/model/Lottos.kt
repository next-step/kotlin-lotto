package lotto.model

class Lottos(val lottos: List<Lotto>) {
    constructor(count: Int) : this(createLottos(count))

    fun check(winningNumbers: List<Int>, checkCount: Int): Int {
        return lottos
            .map { it.getWinningCount(winningNumbers) }
            .filter { it == checkCount }
            .count()
    }

    companion object {
        private fun createLottos(count: Int): List<Lotto> {
            return (1..count).map { Lotto(LottoNumberPool().getLottoNumbers()) }
        }
    }
}
