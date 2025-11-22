package domain

class LottoShuffler {
    companion object {
        private val lotto: Set<Int> = (1..45).toSet()

        fun generateAutomaticLotto(): Lotto =
            Lotto(
                lotto
                    .shuffled()
                    .take(6)
                    .toSet(),
            )
    }
}
