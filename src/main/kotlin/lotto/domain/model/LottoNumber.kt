package lotto.domain.model

data class LottoNumber(val number: Int) {

    init {
        check(number in LOTTO_NUMBER_RANGE) { "로또 숫자는 ${LOTTO_NUMBER_RANGE.first}부터 ${LOTTO_NUMBER_RANGE.last} 사이의 숫자로 구성되어야 합니다" }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = (1..45)
    }
}
