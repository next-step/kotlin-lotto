package lottoAuto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusLottoNumber: LottoNumber
) {
    fun rank(lottoList: List<Lotto>): LottoRanks {
        val ranks = lottoList.map {
            LottoRank.from(
                matchCount = this.countSameNumber(it),
                withBonus = it.withSameNumber(bonusLottoNumber)
            )
        }
        return LottoRanks(ranks)
    }

    private fun countSameNumber(lotto: Lotto): Int {
        return this.lotto.lottoNumbers.intersect(
            lotto.lottoNumbers.toSet()
        ).size
    }
}
