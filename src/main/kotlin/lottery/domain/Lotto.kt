package lottery.domain

import lottery.domain.LottoGame.Companion.LOTTO_SIZE

data class Lotto(
    val lottoNumber: List<LottoNumber>
) {
    init {
        require(lottoNumber.distinct().size == LOTTO_SIZE) { INVALID_LOTTO_SIZE_MESSAGE }
    }

    companion object {
        private const val INVALID_LOTTO_SIZE_MESSAGE = "로또 번호는 총 ${LOTTO_SIZE}개의 숫자여야 합니다."

        fun of(numbers: List<Int>): Lotto {
            return Lotto(numbers.map { LottoNumber(it) })
        }
    }
}
