package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {

    init {
        require(number in LOTTO_START_NUMBER..LOTTO_END_NUMBER) {
            "로또 번호는 $LOTTO_START_NUMBER ~ $LOTTO_END_NUMBER 사이에 중복없는 숫자여야 합니다."
        }
    }

    companion object {
        const val LOTTO_START_NUMBER = 1
        const val LOTTO_END_NUMBER = 45
    }
}
