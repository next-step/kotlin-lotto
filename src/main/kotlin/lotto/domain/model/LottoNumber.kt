package lotto.domain.model

@JvmInline
value class LottoNumber(val value: Int) {
    init {
        require(value in LOTTO_NUMBER_RANGE) {
            "$MESSAGE_INVALID_NUMBER$value"
        }
    }

    companion object {
        private const val MESSAGE_INVALID_NUMBER = "로또 번호는 1에서 45까지의 숫자 중 하나로 이루어져야 합니다.\n현재 입력된 번호 : "

        private const val START_LOTTO_NUMBER = 1
        private const val END_LOTTO_NUMBER = 45

        val LOTTO_NUMBER_RANGE = (START_LOTTO_NUMBER..END_LOTTO_NUMBER)
    }
}
