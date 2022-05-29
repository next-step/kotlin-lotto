package lotto

class LottoEvaluator(private val winningLotto: Lotto) {
    fun evaluate(lotto: Lotto): Winning {
        val count = winningLotto.getMatchNumberCount(lotto)
        return Winning.of(count)
    }
}
