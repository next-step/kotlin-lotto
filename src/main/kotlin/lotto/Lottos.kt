package lotto

class Lottos(private val amountOfLotto: Int, private val manualLottos: List<Lotto>) {
    val lottos = getLottos(amountOfLotto, manualLottos)

    fun getLottos(amountOfLotto: Int, manualLottos: List<Lotto>): List<Lotto> {
        val automaticLottoCount = amountOfLotto - manualLottos.size
        val autoLottos = (1..automaticLottoCount)
            .map { Lotto(LottoProgram.getRandomNumbers()) }
        return manualLottos + autoLottos
    }

    fun matchLottos(winningLotto: WinningNumbers, bonusBall: Int): List<Rank> {
        return lottos.map {
            val count = it.matchLotto(winningLotto)
            val bonusBallResult = it.matchBonusBall(bonusBall)
            Rank.of(count, bonusBallResult)
        }
    }
}
