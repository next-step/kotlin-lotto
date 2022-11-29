package lotto.domain

class Lottos(val lottoList: List<Lotto> = listOf()) {
    val count = lottoList.size

    fun join(lottos: Lottos): Lottos = Lottos(this.lottoList + lottos.lottoList)

    companion object {
        fun of(lottoNumbers: List<Set<LottoNumber>>?): Lottos {
            return if (lottoNumbers.isNullOrEmpty()) Lottos(listOf()) else Lottos(lottoNumbers.map { Lotto(it) })
        }
    }
}
