package lotto.domain.model

@JvmInline
value class LottoNumber(val value: Int) {

    init {
        require(value in LOTTO_NUMBER_START..LOTTO_NUMBER_END) {
            "로또 숫자의 범위는 1~45 입니다."
        }
    }

    companion object {
        const val LOTTO_NUMBER_START = 1
        const val LOTTO_NUMBER_END = 45
    }
}
