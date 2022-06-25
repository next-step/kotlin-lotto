package lotto.fixture

import lotto.domain.BonusNumber
import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.LottoTickets
import lotto.domain.WinningLotto

fun bonusNumber(number: Int): BonusNumber = BonusNumber(number)
fun lotto(vararg numbers: Int): LottoTicket = LottoTicket(numbers.toList())
fun lottoNumber(number: Int): LottoNumber = LottoNumber.from(number)
fun lottoTickets(vararg lotto: LottoTicket) = LottoTickets(lotto.toList())
fun winningLotto(vararg numbers: Int): WinningLotto = WinningLotto(numbers.toList())
