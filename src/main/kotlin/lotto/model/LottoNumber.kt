package lotto.model

data class LottoNumber(
    val value: Int,
) {
    companion object {
        private val LOTTO_NUMBERS: LinkedHashSet<LottoNumber> = LinkedHashSet((1..46).map { LottoNumber(it) })

        fun any6Numbers(): LinkedHashSet<LottoNumber> {
            return LinkedHashSet(
                LOTTO_NUMBERS.shuffled()
                    .subList(0, 6)
            )
        }
    }
}
