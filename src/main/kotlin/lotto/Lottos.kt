package lotto

class Lottos(val lottos: List<Lotto>) {
    fun matchLottos(winningLotto: WinningNumbers, bonusBall: Int): List<Rank> {
        return lottos.map {
            val count = it.matchLotto(winningLotto)
            val bonusBallResult = it.matchBonusBall(bonusBall)
            Rank.of(count, bonusBallResult)
        }
    }

    companion object {
        fun newInstance(amountOfLotto: Int, manualLottos: List<Lotto>): Lottos {
            return Lottos(getLottos(amountOfLotto, manualLottos))
        }

        private fun getLottos(amountOfLotto: Int, manualLottos: List<Lotto>): List<Lotto> {
            val automaticLottoCount = amountOfLotto - manualLottos.size
            val autoLottos = (1..automaticLottoCount)
                .map { Lotto(LottoProgram.getRandomNumbers()) }
            return manualLottos + autoLottos
        }
    }
}
