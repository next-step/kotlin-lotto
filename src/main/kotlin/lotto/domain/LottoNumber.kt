package lotto.domain

@JvmInline
value class LottoNumber(private val number: Int) : Comparable<LottoNumber> {
    init {
        require(number in RAW_LOTTO_MIN_NUMBER..RAW_LOTTO_MAX_NUMBER) { NUMBER_RANGE_ERROR_MESSAGE }
    }

    override fun compareTo(other: LottoNumber): Int {
        return number.compareTo(other.number)
    }

    override fun toString(): String {
        return number.toString()
    }

    operator fun rangeTo(lottoMaxNumber: LottoNumber): List<LottoNumber> {
        return (number..lottoMaxNumber.number).map { LottoNumber(it) }
    }

    operator fun plus(i: Int): LottoNumber {
        return LottoNumber(number + i)
    }

    operator fun minus(i: Int): LottoNumber {
        return LottoNumber(number - i)
    }

    infix fun until(lottoNumber: LottoNumber): List<LottoNumber> {
        return (number until lottoNumber.number).map { LottoNumber(it) }
    }

    companion object {
        val LOTTO_MIN_NUMBER = LottoNumber(1)
        val LOTTO_MAX_NUMBER = LottoNumber(45)

        const val RAW_LOTTO_MIN_NUMBER = 1
        const val RAW_LOTTO_MAX_NUMBER = 45

        val NUMBER_RANGE_ERROR_MESSAGE =
            "로또 번호는 $LOTTO_MIN_NUMBER ~ ${LOTTO_MAX_NUMBER}사이여야 합니다"
    }
}
