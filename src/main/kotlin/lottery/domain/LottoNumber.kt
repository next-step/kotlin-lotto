package lottery.domain

import lottery.domain.LottoGame.Companion.LOTTO_MAX_NUMBER
import lottery.domain.LottoGame.Companion.LOTTO_MIN_NUMBER

@JvmInline
value class LottoNumber(val lottoNumber: Int) {

    init {
        require(lottoNumber in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { INVALID_NUMBER_RANGE_MESSAGE }
    }

    companion object {
        private const val INVALID_NUMBER_RANGE_MESSAGE = "로또 번호는 ${LOTTO_MIN_NUMBER}에서 ${LOTTO_MAX_NUMBER}사이의 값이어야 합니다."
    }
}
