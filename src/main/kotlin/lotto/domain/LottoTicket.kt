package lotto.domain

class LottoTicket(lottoNumberGenerator: () -> Set<Int>) {
    val lottoNumbers = lottoNumberGenerator()

    init {
        require(lottoNumbers.size == LOTTO_NUMBER_COUNT) { INVALID_LOTTO_NUMBER_COUNT_MESSAGE }
    }

    companion object {
        const val LOTTO_NUMBER_MIN_VALUE: Int = 1
        const val LOTTO_NUMBER_MAX_VALUE: Int = 45
        const val LOTTO_NUMBER_COUNT: Int = 6
        const val INVALID_LOTTO_NUMBER_COUNT_MESSAGE: String = "자동 생성된 로또 번호가 6개가 아닙니다"
    }
}
