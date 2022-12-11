package lotto.domain.model

data class LottoNumber(val number: Int) {

    init {
        check(number in LOTTO_NUMBER_RANGE) { "로또 숫자는 1부터 45 사이의 숫자로 구성되어야 합니다" }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = (1..45)
    }
}
