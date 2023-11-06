package lotto.domain

import lotto.constants.WinningRank

class Lotto(val lottoNumbers: LottoNumbers) {

    init {
        validateLotto()
    }

    fun winningRank(winningLotto: WinningLotto): WinningRank {
        val (matchCount, bonusMatchCount) = winningLotto.match(lottoNumbers)
        return WinningRank.of(matchCount, bonusMatchCount)
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
