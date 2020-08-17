package lotto

class Lottos(private val amountOfLotto: Int) {
    val lottos = (0 until amountOfLotto).map { Lotto() }

    fun matchLottos(winningLotto: WinningNumbers, bonusBall: Int): List<Rank> {
        return lottos.map {
            val count = it.matchLotto(winningLotto)
            val bonusBallResult = it.matchBonusBall(bonusBall)
            Rank.of(count, bonusBallResult)
        }
    }
}
