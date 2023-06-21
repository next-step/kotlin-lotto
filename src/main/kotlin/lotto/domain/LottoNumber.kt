package lotto.domain

class LottoNumber(
    val number: Int
) {

    init {
        require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) {
            "로또의 숫자는 ${LOTTO_MIN_NUMBER}부터 $LOTTO_MAX_NUMBER 사이의 숫자만 가능합니다."
        }
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
    }
}