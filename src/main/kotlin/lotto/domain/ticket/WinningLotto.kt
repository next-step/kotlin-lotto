package lotto.domain.ticket

import lotto.domain.LottoNumber

class WinningLotto(
    private val winningLottoTicket: WinningLottoTicket,
    private val bonusNumber: LottoNumber
) {
    fun compare(lottoTicket: LottoTicket): WinningBoard {
        return winningLottoTicket.compare(lottoTicket, bonusNumber)
    }

    init {
        require(winningLottoTicket.hasNot(bonusNumber)) { "보너스 번호($bonusNumber)는 우승 번호와 겹칠수 없습니다." }
    }
}
