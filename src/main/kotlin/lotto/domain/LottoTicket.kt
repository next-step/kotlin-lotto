package lotto.domain

import lotto.domain.exception.LottoSizeMismatchException

class LottoTicket(val numbers: Set<Int>) {
    init {
        require(numbers.size == LOTTO_SIZE) {
            throw LottoSizeMismatchException("6자리 로또 티켓을 입력해주세요.")
        }
    }

    fun isMatch(lottoRank: LottoRank, winningNumber: LottoWinningNumber): Boolean {
        if (lottoRank.matchCount == BONUS_MATCH_COUNT) {
            return compareBonusMatchCount(lottoRank, winningNumber)
        }

        return compareMatchCount(lottoRank.matchCount, winningNumber.winningNumber.numbers)
    }

    private fun compareBonusMatchCount(
        lottoRank: LottoRank,
        winningNumber: LottoWinningNumber
    ): Boolean {
        if (lottoRank.isBonus) {
            return compareMatchCount(lottoRank.matchCount, winningNumber.winningNumber.numbers) &&
                isContainBonusNumber(winningNumber.bonusNumber)
        }

        return compareMatchCount(lottoRank.matchCount, winningNumber.winningNumber.numbers) &&
            !isContainBonusNumber(winningNumber.bonusNumber)
    }

    private fun compareMatchCount(matchCount: Int, winningNumber: Set<Int>): Boolean {
        return numbers.intersect(winningNumber).size == matchCount
    }

    private fun isContainBonusNumber(bonusNumber: Int): Boolean {
        return numbers.contains(bonusNumber)
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val BONUS_MATCH_COUNT = 5
    }
}
