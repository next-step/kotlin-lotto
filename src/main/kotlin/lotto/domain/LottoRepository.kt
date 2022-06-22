package lotto.domain

object LottoRepository {
    val lottos = mutableListOf<Lotto>()

    fun saveAll(lottos: List<Lotto>) = this.lottos.addAll(lottos)

    fun findAll() = this.lottos.toList()
}
