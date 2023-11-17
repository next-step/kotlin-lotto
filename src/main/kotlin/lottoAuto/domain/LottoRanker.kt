package lottoAuto.domain

object LottoRanker {
    fun rank(lottoList: List<Lotto>, winningLotto: WinningLotto): LottoRanks {
        return LottoRanks(
            lottoList
                .map { LottoRank.from(winningLotto.countSameNumber(it)) }
        )
    }
}
