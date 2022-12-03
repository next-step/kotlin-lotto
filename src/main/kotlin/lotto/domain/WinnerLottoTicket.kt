package lotto.domain

import lotto.util.ExceptionMessage

class WinnerLottoTicket(
    lottoGenerateStrategy: LottoGenerateStrategy,
    bonusGenerateStrategy: BonusGenerateStrategy,
) {
    private val winnerLottoNumbers: LottoTicket = LottoTicket(lottoGenerateStrategy)
    private val winnerBonusNumber: LottoNumber = bonusGenerateStrategy.generate()

    init {
        require(winnerBonusNumber !in winnerLottoNumbers) { ExceptionMessage.BONUS_NUMBER_NOT_DUPLICATE_ERROR }
    }

    fun countMatchNumber(lottoTicket: LottoTicket): CountMatchResult {
        val count = lottoTicket.intersect(winnerLottoNumbers).size
        val isBonusNumberMatched = winnerBonusNumber in lottoTicket
        return CountMatchResult(count, isBonusNumberMatched)
    }
}
