package lotto.domain

data class LottoCoupon(
    val numbers: Set<LottoNumber>
) {
    companion object {
        fun of(numbers: Collection<Int>): LottoCoupon {
            val lottoNumbers = numbers.map { LottoNumber(it) }
                .toSet()
            return LottoCoupon(lottoNumbers)
        }
    }
}
