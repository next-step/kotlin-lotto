package lotto.domain

@JvmInline
value class LottoNumber(val number: Int) {
    init {
        require(Lotto.LOTTO_NUMBER_RANGE.contains(number)) {
            "로또 번호는 ${Lotto.LOTTO_NUMBER_RANGE} 에 있어야 합니다."
        }
    }

    override fun toString(): String {
        return number.toString()
    }
}
