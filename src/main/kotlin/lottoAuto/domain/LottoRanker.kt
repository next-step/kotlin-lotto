package lottoAuto.domain

object LottoRanker {
    fun rank(lottoList: List<Lotto>, winningLotto: Lotto): List<LottoRank> {
        return lottoList
            .map { LottoRank.from(it, winningLotto) }
    }
}
