package lotto

class WinningLotto(private val winningLotto: Lotto, private val bonusNumber: Int) {
    init {
        require(!winningLotto.numbers.contains(bonusNumber))
    }

    private fun evaluate(lotto: Lotto): Winning {
        val count = winningLotto.countMatchedNumber(lotto)
        val isMatchBonusNumber = winningLotto.contains(bonusNumber)
        return Winning.of(count, isMatchBonusNumber)
    }

    fun evaluate(lottos: Lottos): List<Winning> {
        return lottos.lottos.map { evaluate(it) }
    }
}
