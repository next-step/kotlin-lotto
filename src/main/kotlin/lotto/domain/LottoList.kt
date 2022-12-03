package lotto.domain

data class LottoList(
    val lottoList: List<Lotto>
) {
    fun compare(winningLotto: WinningLotto): List<LottoRank> =
        lottoList.map { lotto ->
            winningLotto.compare(lotto)
        }

    fun count(): Int = lottoList.count()

    fun addLottoList(otherLottoList: LottoList): LottoList =
        LottoList(lottoList + otherLottoList.lottoList)

    fun printLottoList() {
        lottoList.forEach { lotto ->
            println(lotto.numbers)
        }
    }
}
