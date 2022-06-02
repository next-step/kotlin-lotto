package lotto

class WinningLotto(private val winningLotto: Lotto) {
    private fun evaluate(lotto: Lotto): Winning {
        val count = winningLotto.countMatchedNumber(lotto)
        return Winning.of(count)
    }

    fun evaluate(lottos: Lottos): List<Winning> {
        return lottos.lottos.map { evaluate(it) }
    }
}
