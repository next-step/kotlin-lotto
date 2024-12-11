package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER) { "로또 번호는 1보다 적거나 45보다 클 수 없습니다" }
    }

    companion object {
        const val LOTTO_MIN_NUMBER = 1
        const val LOTTO_MAX_NUMBER = 45
    }
}
