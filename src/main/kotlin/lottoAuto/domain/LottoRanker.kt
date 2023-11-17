package lottoAuto.domain

object LottoRanker {
    fun rank(
        lottoList: List<Lotto>,
        winningLotto: WinningLotto,
        bonusLottoNumber: LottoNumber
    ): LottoRanks {
        val ranks = lottoList.map {
            LottoRank.from(
                matchCount = winningLotto.countSameNumber(it),
                withBonus = it.withBonusNumber(bonusLottoNumber)
            )
        }
        return LottoRanks(ranks)
    }
}
