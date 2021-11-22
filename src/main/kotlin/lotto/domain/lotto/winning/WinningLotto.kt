package lotto.domain.lotto.winning

import lotto.domain.lotto.error.LottoExceptionMessage

class WinningLotto(
    private val winningLottoNumber: List<Int>
) {

    init {
        require(winningLottoNumber.size == 6) { IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_OVERLAP) }
    }

    fun containsLottoNumber(lottoNumber: Int): Boolean {
        return winningLottoNumber.contains(lottoNumber)
    }
}
