package lotto

class Lottos(private val amountOfLotto: Int, private val manualLottos: List<Lotto>) {
    val lottos = getLottos(amountOfLotto, manualLottos)

    fun getLottos(amountOfLotto: Int, manualLottos: List<Lotto>): List<Lotto> {
        val lottos = manualLottos.toMutableList()
        val automaticLottoCount = amountOfLotto - manualLottos.size
        for (number in 0 until automaticLottoCount) {
            lottos.add(Lotto(LottoProgram.getRandomNumbers()))
        }
        return lottos.toList()
    }

    fun matchLottos(winningLotto: WinningNumbers, bonusBall: Int): List<Rank> {
        return lottos.map {
            val count = it.matchLotto(winningLotto)
            val bonusBallResult = it.matchBonusBall(bonusBall)
            Rank.of(count, bonusBallResult)
        }
    }
}
