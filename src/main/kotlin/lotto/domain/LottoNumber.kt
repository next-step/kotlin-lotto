package lotto.domain

data class LottoNumber(private val number: Int) {
    init {
        require(isValidRange(number)) { "$number 은 로또 숫자에 포함되지 않는 숫자입니다" }
    }

    private fun isValidRange(number: Int): Boolean {
        return number in LOTTO_MINIMUM..LOTTO_MAXIMUM
    }

    override fun toString(): String {
        return "$number"
    }

    companion object {
        val baseLottoNumbers: List<LottoNumber> = List(45) { LottoNumber(it + 1) }
        const val LOTTO_MINIMUM = 1
        const val LOTTO_MAXIMUM = 45
    }
}
