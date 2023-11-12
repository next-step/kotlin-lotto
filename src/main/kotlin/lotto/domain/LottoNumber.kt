package lotto.domain

data class LottoNumber(val number: Int) {
    init {
        require(number in Lotto.LOTTO_NUMBER_MIN..Lotto.LOTTO_NUMBER_MAX) { "로또 번호는 1부터 45까지의 숫자만 가능합니다." }
    }

    fun List<LottoNumber>.contains(lottoNumber: LottoNumber): Boolean {
        return this.any { it.number == lottoNumber.number }
    }

    override fun toString(): String {
        return number.toString()
    }
}
