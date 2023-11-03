package lotto.domain

import lotto.constants.WinningRank

class Lotto(val lottoNumbers: LottoNumbers) {

    init {
        validateLotto()
    }

    fun winningRank(winningLotto: WinningLotto): WinningRank {
        val (matchCount, bonusMatchCount) = match(winningLotto)
        if (matchCount == 5) return WinningRank.of(matchCount, bonusMatchCount)
        return WinningRank.of(matchCount)
    }

    private fun match(winningLotto: WinningLotto): Pair<Int, Boolean> {
        return Pair(
            lottoNumbers.matchNumbersCount(winningLotto.lottoNumbers),
            lottoNumbers.matchNumbers(winningLotto.bonusNumber)
        )
    }

    private fun validateLotto() {
        require(lottoNumbers.numbers.size == LOTTO_NUMBER_SIZE) {
            "로또는 ${LOTTO_NUMBER_SIZE}개의 숫자만 가질 수 있습니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
