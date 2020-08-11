package lotto.domain.generator

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object AutoLottoGenerator : LottoGenerator {

    override fun execute() = LottoTicket(
        LottoNumber.NUMBER_RANGE.shuffled()
            .take(LottoTicket.NUMBER_COUNT)
            .map { LottoNumber(it) }
            .toSortedSet()
    )
}
