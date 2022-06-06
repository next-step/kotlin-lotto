package lotto.domain

class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) { "로또 번호가 유효 범위내에 있지 않습니다." }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = 1..45
    }
}
