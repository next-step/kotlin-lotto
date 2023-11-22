package lottoAuto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusLottoNumber: LottoNumber
) {
    init {
        require(!lotto.withSameNumber(bonusLottoNumber)) { "보너스 번호는 당첨 번호와 중복될 수 없습니다." }
    }

    fun rank(lottos: List<Lotto>): LottoRanks {
        val ranks = lottos.map {
            LottoRank.from(
                matchCount = this.lotto.countSameNumber(it),
                withBonus = it.withSameNumber(bonusLottoNumber)
            )
        }
        return LottoRanks(ranks)
    }
}
