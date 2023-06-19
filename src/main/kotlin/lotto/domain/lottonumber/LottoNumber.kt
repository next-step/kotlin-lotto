package lotto.domain.lottonumber

@JvmInline
value class LottoNumber(val value: Int) : Comparable<LottoNumber> {

    init {
        require(value in LOTTO_NUMBER_RANGE) {
            "lotto number must be between ${LOTTO_NUMBER_RANGE.first} and ${LOTTO_NUMBER_RANGE.last}"
        }
    }

    override fun compareTo(other: LottoNumber): Int {
        return value.compareTo(other.value)
    }

    companion object {

        private val LOTTO_NUMBER_RANGE = (1..45)

        fun allLottoNumbers(): List<LottoNumber> {
            return LOTTO_NUMBER_RANGE.map { LottoNumber(it) }
        }
    }
}

fun List<LottoNumber>.unWrapping() = map { it.value }
