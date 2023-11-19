package lottoAuto.domain

data class WinningLotto(
    val winningLottoNumbers: List<LottoNumber>,
    val bonusLottoNumber: LottoNumber
) {
    fun rank(lottoList: List<Lotto>): LottoRanks {
        val ranks = lottoList.map {
            LottoRank.from(
                matchCount = this.countSameNumber(it),
                withBonus = it.withBonusNumber(bonusLottoNumber)
            )
        }
        return LottoRanks(ranks)
    }

    private fun countSameNumber(lotto: Lotto): Int {
        return winningLottoNumbers.intersect(
            lotto.lottoNumbers.toSet()
        ).size
    }
}
