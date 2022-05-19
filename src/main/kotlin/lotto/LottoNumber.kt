package lotto

data class LottoNumber(private val number: Int) {

    init {
        require(number in (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER)) {
            "로또 번호는 1~45의 숫자만 생성이 가능합니다"
        }
    }

    companion object {
        private const val LOTTO_MIN_NUMBER = 1
        private const val LOTTO_MAX_NUMBER = 45
    }
}
