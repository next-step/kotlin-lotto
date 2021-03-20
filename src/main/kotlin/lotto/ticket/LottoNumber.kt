package lotto.ticket

data class LottoNumber(private val number: Int) {

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45

        val LOTTO_NUMBER_BOX: Map<Int, LottoNumber> = (MIN_NUMBER..MAX_NUMBER)
            .map {
                it to LottoNumber(it)
            }.toMap()

        fun drawNumber(number: Int): LottoNumber {
            return LOTTO_NUMBER_BOX[number] ?: throw IllegalArgumentException("로또번호($number)는 없습니다.")
        }
    }

    override fun toString(): String {
        return "$number"
    }
}
