package lotto.fixture

import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningLotto

fun lotto(vararg numbers: Int): LottoTicket = LottoTicket(numbers.toList())
fun lottoTickets(vararg lotto: LottoTicket) = LottoTickets(lotto.toList())
fun winningLotto(vararg numbers: Int): WinningLotto = WinningLotto(numbers.toList())
