package lotto.domain

data class Lottos(val lottoList: List<Lotto>) : Iterable<Lotto> {

    val size: Int = lottoList.size

    override fun iterator(): Iterator<Lotto> =
        lottoList.iterator()
}
