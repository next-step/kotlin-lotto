package lotto.domain

import lotto.constants.WinningRank

class Lotto(numbers: List<LottoNumber>) {

    val numbers = numbers.map { it.number }

    init {
        validateLotto()
    }

    fun matchCount(winningLotto: WinningLotto): Int {
        return numbers.filter { winningLotto.lotto.numbers.contains(it) }.size
    }

    fun winningRank(winningLotto: WinningLotto): WinningRank {
        val matchCount = matchCount(winningLotto)
        return WinningRank.of(matchCount)
    }

    private fun validateLotto() {
        require(numbers.size == LOTTO_NUMBER_SIZE) {
            "로또는 ${LOTTO_NUMBER_SIZE}개의 숫자만 가질 수 있습니다."
        }

        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) {
            "로또는 중복되지 않는 숫자만 가질 수 있습니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
    }
}
