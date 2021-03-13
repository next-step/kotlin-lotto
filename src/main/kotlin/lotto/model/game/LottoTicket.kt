package lotto.model.game

import lotto.model.result.Coincidence

class LottoTicket(val lottos: Lottos, val winningLotto: WinningLotto) {
    fun getMatchedLottoCount(coincidence: Coincidence): Int {
        return lottos.getCoincidenceCount(coincidence, winningLotto)
    }
}
