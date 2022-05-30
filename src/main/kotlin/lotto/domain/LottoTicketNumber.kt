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
    }
}
