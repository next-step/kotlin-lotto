package lotto.domain

import lotto.util.ExceptionMessage
import lotto.util.Parser
import lotto.util.Reader

class LottoManualGenerateStrategy : LottoGenerateStrategy {
    override fun generate(): LottoTicket {
        val winnerLottoNumbersStr = Reader.read()
        val lottoNumbers = Parser.parse(winnerLottoNumbersStr)
        validateLottoNumbers(lottoNumbers)
        return LottoTicket(lottoNumbers.map { LottoNumber(it) }.toSet())
    }

    private fun validateLottoNumbers(lottoNumbers: List<Int>) {
        require(lottoNumbers.toSet().size == 6) { ExceptionMessage.LOTTO_NUMBER_SIZE_ERROR }
    }
}
