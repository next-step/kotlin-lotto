package lotto.domain

import lotto.constants.WinningRank
import lotto.domain.LottoStore.LOTTO_NUMBER_SIZE

@JvmInline
value class Lotto(val numbers: List<Int>) {

    init {
        validateLottoNumber()
    }

    private fun validateLottoNumber() {
        require(numbers.size == LOTTO_NUMBER_SIZE) {
            "로또는 ${LOTTO_NUMBER_SIZE}개의 숫자만 가질 수 있습니다."
        }
    }

    fun matchCount(winningLotto: Lotto): Int {
        return numbers.filter { winningLotto.numbers.contains(it) }.size
    }

    fun winningRank(winningLotto: Lotto): WinningRank {
        val matchCount = matchCount(winningLotto)
        return WinningRank.of(matchCount)
    }
}
