package lotto

class ManualWinnerLottoTicket : WinnerLottoTicket {
    override val winnerLottoNumbers: Set<LottoNumber> = emptySet()
}
