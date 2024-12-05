package study.lotto.model

/**
 * @author 이상준
 */
@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { ERROR_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        private const val ERROR_LOTTO_NUMBER_MESSAGE = "로또 번호는 1부터 45까지 가능합니다."
    }
}
