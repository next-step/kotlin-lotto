package lotto.domain

@JvmInline
value class LottoTicketNumber(val value: Int) {
    init {
        require(value in VALIDATED_LOTTO_NUMBER_RANGE) { ERROR_MESSAGE_BY_OUT_RANGE_NUMBER }
    }

    companion object {
        private val VALIDATED_LOTTO_NUMBER_RANGE = 1..45
        private val ERROR_MESSAGE_BY_OUT_RANGE_NUMBER =
            "로또 숫자는 최소 ${VALIDATED_LOTTO_NUMBER_RANGE.first} 이상 ${VALIDATED_LOTTO_NUMBER_RANGE.last} 이하에 값을 넣을수 있습니다"
    }
}
