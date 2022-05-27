package lotto.domain

class LottoNumber(
    private val value: Int
) {
    init {
        require(value in MIN_LOTTO_NUM..MAX_LOTTO_NUM) { "로또 번호가 아닙니다." }
    }

    fun get() = value

    companion object {
        const val MIN_LOTTO_NUM = 1
        const val MAX_LOTTO_NUM = 45

        fun random(): LottoNumber {
            val number = (MIN_LOTTO_NUM..MAX_LOTTO_NUM).random()
            return LottoNumber(number)
        }
    }
}
