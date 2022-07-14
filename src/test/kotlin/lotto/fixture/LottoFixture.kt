package lotto.fixture

import lotto.domain.lotto.BonusNumber
import lotto.domain.lotto.LottoTicket
import lotto.domain.lotto.LottoTickets
import lotto.domain.lotto.ManualLottos
import lotto.domain.lotto.WinningLotto
import lotto.domain.lottonumber.LottoNumber

fun bonusNumber(number: Int): BonusNumber = BonusNumber(number)
fun lotto(vararg numbers: Int): LottoTicket = LottoTicket(numbers.toList())
fun lottoNumber(number: Int): LottoNumber = LottoNumber.from(number)
fun lottoTickets(vararg lotto: LottoTicket) = LottoTickets(lotto.toList())
fun manualLotto(vararg numbers: List<Int>): ManualLottos = ManualLottos(numbers.toList())
fun winningLotto(vararg numbers: Int): WinningLotto = WinningLotto(numbers.toList())
