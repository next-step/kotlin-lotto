package lotto.domain

class Lottos(val lottoList: List<Lotto> = listOf()) {
    val count = lottoList.size

    fun join(lottos: Lottos): Lottos = Lottos(this.lottoList + lottos.lottoList)
}
