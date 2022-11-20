package lotto

import lotto.util.ExceptionMessage
import lotto.util.Parser
import lotto.util.Reader

class ManualWinnerLottoTicket : WinnerLottoTicket {
    override val winnerLottoNumbers: Set<LottoNumber>

    init {
        val winnerLottoNumbersStr = Reader.read()
        val lottoNumbers = Parser.parse(winnerLottoNumbersStr)
        validateLottoNumbers(lottoNumbers)
        this.winnerLottoNumbers = lottoNumbers.map { LottoNumber(it) }.toSet()
    }

    private fun validateLottoNumbers(lottoNumbers: List<Int>) {
        require(lottoNumbers.toSet().size == 6) { ExceptionMessage.LOTTO_NUMBER_SIZE_ERROR }
    }
}
