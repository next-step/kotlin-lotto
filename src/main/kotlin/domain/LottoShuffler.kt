package domain

class LottoShuffler {
    companion object {
        private val availableLottoNumbers: Set<Int> = (Lotto.MIN_NUMBER..Lotto.MAX_NUMBER).toSet()

        fun generateAutomaticLotto(): Lotto =
            Lotto(
                availableLottoNumbers
                    .shuffled()
                    .take(Lotto.SIZE)
                    .toSet(),
            )
    }
}
