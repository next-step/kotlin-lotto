package lotto.domain

data class LottoList(
    val lottoList: List<Lotto>
) {
    fun compare(winningLotto: Lotto, bonusLottoNumber: LottoNumber): List<LottoRank> =
        lottoList.map { lotto: Lotto ->
            val matchCount = winningLotto.getMatchCount(lotto)
            val isBonusMatch = lotto.containLottoNumber(bonusLottoNumber)
            LottoRank.valueOf(matchCount, isBonusMatch)
        }

    fun count(): Int = lottoList.count()

    fun addLottoList(otherLottoList: LottoList): LottoList =
        LottoList(lottoList.plus(otherLottoList.lottoList))

    fun printLottoList() {
        lottoList.forEach { lotto ->
            println(lotto.numbers)
        }
    }
}
