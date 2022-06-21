package lotto.domain

object LottoFactory {
    fun auto(lottoNumber: Int): Lottos {
        return mutableListOf<Lotto>().apply {
            repeat(lottoNumber) {
                add(LottoNumber.ALL.shuffled().toLotto())
            }
        }.let { Lottos(it.toList()) }
    }
}

private fun List<LottoNumber>.toLotto() = Lotto(this.take(Lotto.LOTTO_LENGTH).toSet())
