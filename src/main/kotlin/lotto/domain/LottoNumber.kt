package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX) { "로또 번호는 1부터 45 사이여야 합니다." }
    }
}
