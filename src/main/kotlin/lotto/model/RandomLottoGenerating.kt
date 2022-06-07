package lotto.model

object RandomLottoGenerating : LottoGeneratingStrategy {
    override fun generateLottos(count: Int): Lottos {
        val lottos = List(count) { generateRandomLotto() }
        return Lottos(lottos)
    }

    private fun generateRandomLotto(): Lotto {
        val shuffledNumbers = LottoNumber.LOTTO_NUMBERS.shuffled()
            .subList(0, Lotto.LOTTO_NUMBER_COUNT)
            .sortedBy { it.number }

        return Lotto(shuffledNumbers)
    }
}
