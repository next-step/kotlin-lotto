package lotto.domain.generator

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket

object AutoLottoGenerator : LottoGenerator {

    override fun execute() = (LottoNumber.MIN..LottoNumber.MAX).shuffled().take(LottoTicket.NUMBER_COUNT)
}
