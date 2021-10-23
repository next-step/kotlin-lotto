package lotto.domain

@JvmInline
value class LottoNumber(val value: Int) {

    init {
        require(value in MINIMUM_LOTTO_NUMBER..MAXIMUM_LOTTO_NUMBER) { WRONG_LOTTO_NUMBER_MESSAGE }
    }

    companion object {
        private const val MINIMUM_LOTTO_NUMBER = 1
        private const val MAXIMUM_LOTTO_NUMBER = 45
        private const val WRONG_LOTTO_NUMBER_MESSAGE = "잘못된 로또 번호 입니다.($MINIMUM_LOTTO_NUMBER~$MAXIMUM_LOTTO_NUMBER})"
    }
}
