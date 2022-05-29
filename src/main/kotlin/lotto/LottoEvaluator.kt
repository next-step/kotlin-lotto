package lotto

class LottoEvaluator(private val winningLotto: Lotto) {
    private fun evaluate(lotto: Lotto): Winning {
        val count = winningLotto.getMatchNumberCount(lotto)
        return Winning.of(count)
    }

    fun evaluate(lottos: List<Lotto>): List<Winning> {
        return lottos.map { evaluate(it) }
    }
}
