package lotto.domain

data class LottoNumber(val number: Int) {

    init {
        require(number in (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)) {
            "로또 번호는 $LOTTO_MIN_NUMBER ~ $LOTTO_MAX_NUMBER 의 숫자만 생성이 가능합니다"
        }
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }
}
