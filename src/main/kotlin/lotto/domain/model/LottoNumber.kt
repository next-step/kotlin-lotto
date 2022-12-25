package lotto.domain.model

data class LottoNumber(val number: Int) {

    init {
        check(number in LOTTO_NUMBER_RANGE) { "로또 숫자는 ${FIRST_LOTTO_NUMBER}부터 $LAST_LOTTO_NUMBER 사이의 숫자로 구성되어야 합니다" }
    }

    companion object {
        const val FIRST_LOTTO_NUMBER = 1
        const val LAST_LOTTO_NUMBER = 45
        val LOTTO_NUMBER_RANGE = (FIRST_LOTTO_NUMBER..LAST_LOTTO_NUMBER)
    }
}
