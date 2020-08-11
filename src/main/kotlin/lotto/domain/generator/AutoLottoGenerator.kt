package lotto.domain.generator

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object AutoLottoGenerator : LottoGenerator {

    override fun execute() = LottoTicket(LottoNumber.take(LottoTicket.NUMBER_COUNT).toSortedSet())
}
