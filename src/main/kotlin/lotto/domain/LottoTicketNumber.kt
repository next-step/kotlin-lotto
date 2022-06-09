package lotto.domain

@JvmInline
value class LottoTicketNumber(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE) { ERROR_MESSAGE_BY_OUT_RANGE_NUMBER }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
        private val ERROR_MESSAGE_BY_OUT_RANGE_NUMBER =
            "로또 숫자는 최소 ${LOTTO_NUMBER_RANGE.first} 이상 ${LOTTO_NUMBER_RANGE.last} 이하에 값을 넣을수 있습니다"

        fun ofString(lottoNumberString: String): LottoTicketNumber {
            return LottoTicketNumber(
                lottoNumberString.trim().toIntOrNull()
                    ?: throw IllegalArgumentException("숫자 데이터를 입력해주세요(입력값: $lottoNumberString)")
            )
        }
    }
}
