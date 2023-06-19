package lotto.domain
data class LottoNumber(val number: Int) : Comparable<LottoNumber> {
    init {
        require(number > 0) { "로또 번호는 1이상 이어야 합니다." }
        require(number < 46) { "로또 번호는 45이하 이어야 합니다." }
    }

    override fun compareTo(other: LottoNumber): Int {
        return this.number.compareTo(other.number)
    }

    companion object {
        private val LOTTO_NUMBERS = (1..45).map { LottoNumber(it) }
        fun random(count: Int): List<LottoNumber> {
            return LOTTO_NUMBERS.shuffled()
                .subList(0, count)
                .sorted()
        }
    }
}
