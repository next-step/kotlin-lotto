package lotto

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(number in LOTTO_NUMBER_RANGE) { "로또 번호는 $LOTTO_NUMBER_RANGE 이내여야 합니다." }
    }

    companion object {
        val LOTTO_NUMBER_RANGE = (1..45)
    }
}
