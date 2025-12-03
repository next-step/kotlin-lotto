package domain

class LottoShuffler {
    companion object {
        private val lotto: Set<LottoNumber> = (1..45).map { LottoNumber(it) }.toSet()

        fun generateAutomaticLotto(): Lotto =
            Lotto(
                lotto
                    .shuffled()
                    .take(6)
                    .toSet(),
            )
    }
}
