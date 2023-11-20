package lotto.domain

class LottoWinning(private val jackpotNumbers: Lotto, private val bonusNumber: LottoNumber) {

    fun checkWinningLottos(lottos: Lottos): List<JackpotLevel> {
        return lottos.checkLottoWinning(jackpotNumbers, bonusNumber)
    }
}
