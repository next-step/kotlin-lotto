package lotto.domain

import lotto.util.ExceptionMessage

class WinnerLottoTicket(
    lottoGenerateStrategy: LottoGenerateStrategy,
    bonusGenerateStrategy: BonusGenerateStrategy,
) {
    private val winnerLottoNumbers: Set<LottoNumber> = lottoGenerateStrategy.generate()
    private val winnerBonusNumber: LottoNumber = bonusGenerateStrategy.generate()

    init {
        require(winnerBonusNumber !in winnerLottoNumbers) { ExceptionMessage.BONUS_NUMBER_NOT_DUPLICATE_ERROR }
    }

    fun countMatchNumber(lottoNumber: Set<LottoNumber>): CountMatchResult {
        val count = lottoNumber.intersect(winnerLottoNumbers).size
        val isBonusNumberMatched = winnerBonusNumber in lottoNumber
        return CountMatchResult(count, isBonusNumberMatched)
    }
}
