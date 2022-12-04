package lotto.domain.strategy.lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoTicket
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
        require(lottoNumbers.toSet().size == 6) { LOTTO_NUMBER_SIZE_ERROR }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE_ERROR = "로또 번호는 6개의 숫자로 이루어져 있어요. (중복 불가)"
    }
}
