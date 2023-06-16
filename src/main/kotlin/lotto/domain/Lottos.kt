package lotto.domain

data class Lottos(val lottoList: List<Lotto>) : Iterable<Lotto> {
    val size: Int
        get() {
            return lottoList.size
        }

    override fun iterator(): Iterator<Lotto> =
        lottoList.iterator()
}
