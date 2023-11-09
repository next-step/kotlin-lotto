package lotto.model

data class LottoInput(
    val lottoTickets: List<LottoTicket>,
    val winningNumbers: WinningNumbers
)
