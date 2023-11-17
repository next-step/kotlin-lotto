package lottoAuto.domain

object LottoRanker {
    fun rank(lottoList: List<Lotto>, winningLotto: WinningLotto): List<LottoRank> {
        return lottoList
            .map { LottoRank.from(winningLotto.countSameNumber(it)) }
    }
}
