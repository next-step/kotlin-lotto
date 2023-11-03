package lotto.domain

import lotto.constants.WinningRank

@JvmInline
value class Lotto(val numbers: List<Int>) {

    init {
        validateLottoNumber()
    }

    fun matchCount(winningLotto: Lotto): Int {
        return numbers.filter { winningLotto.numbers.contains(it) }.size
    }

    fun winningRank(winningLotto: Lotto): WinningRank {
        val matchCount = matchCount(winningLotto)
        return WinningRank.of(matchCount)
    }

    private fun validateLottoNumber() {
        require(numbers.size == LOTTO_NUMBER_SIZE) {
            "로또는 ${LOTTO_NUMBER_SIZE}개의 숫자만 가질 수 있습니다."
        }

        require(numbers.toSet().size == LOTTO_NUMBER_SIZE) {
            "로또는 중복되지 않는 숫자만 가질 수 있습니다."
        }

        require(numbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) {
            "로또는 $LOTTO_NUMBER_MIN~${LOTTO_NUMBER_MAX}의 숫자만 가질 수 있습니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_SIZE = 6
        const val LOTTO_NUMBER_MIN = 1
        const val LOTTO_NUMBER_MAX = 45
    }
}
