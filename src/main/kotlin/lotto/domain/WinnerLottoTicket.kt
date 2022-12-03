package lotto.domain

class WinnerLottoTicket(
    private val winnerLottoNumbers: LottoTicket,
    private val winnerBonusNumber: LottoNumber
) {
    init {
        require(winnerBonusNumber !in winnerLottoNumbers) { BONUS_NUMBER_NOT_DUPLICATE_ERROR }
    }

    fun countMatchNumber(lottoTicket: LottoTicket): CountMatchResult {
        val count = lottoTicket.intersect(winnerLottoNumbers).size
        val isBonusNumberMatched = winnerBonusNumber in lottoTicket
        return CountMatchResult(count, isBonusNumberMatched)
    }

    companion object {
        const val BONUS_NUMBER_NOT_DUPLICATE_ERROR = "보너스 번호는 기존 로또 넘버와 중복될 수 없어요."
    }
}
