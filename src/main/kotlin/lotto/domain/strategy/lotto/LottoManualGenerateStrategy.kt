package lotto.domain.strategy.lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
import lotto.domain.input.ClientInput
import lotto.util.Parser

class LottoManualGenerateStrategy(
    private val clientInput: ClientInput,
) : LottoGenerateStrategy {
    override val generateType = GenerateType.MANUAL
    override fun generate(): LottoTicket {
        val winnerLottoNumbersStr = clientInput.read()
        val lottoNumbers = Parser.parse(winnerLottoNumbersStr)
        return LottoTicket(lottoNumbers.map { LottoNumber(it) }.toSet())
    }
}
