package lotto

class LotteryWinningChecker(val winningTicket: LottoTicket, val bonusNumber: LottoNumber) {
    init {
        require(!winningTicket.contain(bonusNumber)) {
            "보너스 번호는 1등 로또 번호에 포함되지 않아야 합니다: winningTicket=$winningTicket, bonusNumber=$bonusNumber"
        }
    }

    fun checkTicket(lottoTicket: LottoTicket): WinningResult {
        return WinningResult.valueOf(lottoTicket.countOfMatches(winningTicket), lottoTicket.matchesBonusBall(bonusNumber))
    }
}
