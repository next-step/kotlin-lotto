package lotto.domain.lottonumber

@JvmInline
value class LottoNumbers(val value: List<LottoNumber>) {

    init {
        require(value.size == LOTTO_NUMBER_REQUIRE_SIZE) {
            "lotto numbers size must be 6"
        }

        require(value.size == value.distinct().size) {
            "lotto numbers must not have duplicate"
        }
    }

    operator fun contains(lottoNumber: LottoNumber): Boolean {
        return value.contains(lottoNumber)
    }

    fun matchCount(other: LottoNumbers): Int {
        val numberSet = value.toSet()
        return other.value.count { numberSet.contains(it) }
    }

    companion object {

        private const val LOTTO_NUMBER_REQUIRE_SIZE = 6
    }
}
