package lotto.entity

@JvmInline
value class LottoNumber(val value: Int) {

    init {
        require(value in MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) { "로또 번호는 $MIN_LOTTO_NUMBER~$MAX_LOTTO_NUMBER 사이여야 합니다." }
    }

    override fun toString(): String {
        return value.toString()
    }

    companion object {
        const val MAX_LOTTO_NUMBER = 45
        const val MIN_LOTTO_NUMBER = 1
        val LOTTO_NUMBERS = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER).toList()
    }
}
