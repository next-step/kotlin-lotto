package lotto.domain

object LottoFactory {
    fun generateAutoLottos(amountOfLotto: Int, lottoGeneratorStrategy: () -> Lotto): Lottos {
        val lottos = List(amountOfLotto) { lottoGeneratorStrategy.invoke() }.toList()
        return Lottos(lottos)
    }

    fun generateManualLottos(lottos: List<Lotto>): Lottos {
        return Lottos(lottos)
    }
}

fun generateAutoLotto() = LottoNumber.ALL.shuffled().toLotto()

private fun List<LottoNumber>.toLotto() = Lotto(this.take(Lotto.LOTTO_LENGTH).toSet())
