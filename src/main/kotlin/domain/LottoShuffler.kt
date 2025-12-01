package domain

class LottoShuffler {
    companion object {
        private val availableLottoNumbers: Set<LottoNumber> =
            (LottoNumber.MIN_NUMBER..LottoNumber.MAX_NUMBER).map { LottoNumber(it) }.toSet()

        fun generateAutomaticLotto(): Lotto =
            Lotto(
                availableLottoNumbers
                    .shuffled()
                    .take(Lotto.SIZE)
                    .toSet(),
            )
    }
}
