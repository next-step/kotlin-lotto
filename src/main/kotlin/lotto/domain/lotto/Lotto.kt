package lotto.domain.lotto

import lotto.domain.lotto.error.LottoExceptionMessage

class Lotto(
    private val _lottoNumber: List<Int>
) {

    val lottoNumber get() = _lottoNumber.sorted()

    init {
        require(_lottoNumber.distinct().size == 6) { LottoExceptionMessage.LOTTO_NUMBER_OVERLAP }
    }
}
