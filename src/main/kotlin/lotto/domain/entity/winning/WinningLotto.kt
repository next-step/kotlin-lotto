package lotto.domain.entity.winning

import lotto.domain.entity.error.LottoExceptionMessage

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
