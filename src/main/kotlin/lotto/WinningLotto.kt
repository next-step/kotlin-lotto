package lotto

class WinningLotto(private val winningLotto: Lotto) {
    private fun evaluate(lotto: Lotto): Winning {
        val count = winningLotto.countMatchedNumber(lotto)
        return Winning.of(count)
    }

    fun evaluate(lottos: List<Lotto>): List<Winning> {
        return lottos.map { evaluate(it) }
    }
}
