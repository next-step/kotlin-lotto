package lotto.domain

object LottoFactory {
    fun generateAutoLottos(amountOfLotto: Int): Lottos {
        val lottos = List(amountOfLotto) { generateAutoLotto() }.toList()
        return Lottos(lottos)
    }

    private fun generateAutoLotto() = LottoNumber.ALL.shuffled().toLotto()

    fun generateManualLottos(lottos: List<Lotto>): Lottos {
        return Lottos(lottos)
    }
}

private fun List<LottoNumber>.toLotto() = Lotto(this.take(Lotto.LOTTO_LENGTH).toSet())
