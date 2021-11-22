package lotto.domain.lotto.winning

import lotto.domain.lotto.error.LottoExceptionMessage
import lotto.filter.LottoFilter

class WinningLotto(
    lottoNumber: String
) {

    private val _winningLottoNumber: List<Int>
    val winningLottoNumber get() = _winningLottoNumber

    init {
        _winningLottoNumber = lottoNumber
            .split(",")
            .map { LottoFilter.verify(it.trim().toInt()) }
            .distinct()
            .sorted()

        require(_winningLottoNumber.size == 6) { IllegalArgumentException(LottoExceptionMessage.LOTTO_NUMBER_OVERLAP) }
    }

    fun containsLottoNumber(lottoNumber: Int): Boolean {
        return _winningLottoNumber.contains(lottoNumber)
    }
}
