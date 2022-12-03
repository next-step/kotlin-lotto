package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in 1..45) { LOTTO_NUMBER_ERROR }
    }

    companion object {
        const val LOTTO_NUMBER_ERROR = "로또 번호는 1번 ~ 45번 사이의 숫자만 가질 수 있어요."
    }
}
