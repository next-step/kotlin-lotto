package lotto.domain.entity.user

import lotto.domain.entity.common.LottoNumber
import lotto.domain.entity.error.LottoExceptionMessage

class Lotto(
    private val lottoNumber: List<LottoNumber>
) {

    init {
        require(lottoNumber.distinct().size == LOTTO_NUMBER_COUNT) { LottoExceptionMessage.LOTTO_NUMBER_OVERLAP }
    }

    fun getLottoNumber(): List<LottoNumber> = lottoNumber
        .sortedBy { it.number }
        .toList()

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
