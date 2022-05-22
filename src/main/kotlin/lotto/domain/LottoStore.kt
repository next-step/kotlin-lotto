package lotto.domain

class LottoStore(private val money: Int, private val lottoMaker: LottoMaker = LottoMakerImpl()) {
    val lottoCount = money / EACH_LOTTO_PRICE
    val boughtLottos = mutableListOf<List<Int>>()
    val totalYieldRatio
        get() = totalMoney.toFloat() / money
    private var totalMoney = 0

    init {
        repeat(lottoCount) {
            boughtLottos.add(lottoMaker.makeLottoNumbers())
        }
    }

    fun getWinnerInfos(answer: List<Int>): List<LottoResult> {
        val winnerInfos = listOf(
            LottoResult(LottoWinInfo.WIN3, 0),
            LottoResult(LottoWinInfo.WIN4, 0),
            LottoResult(LottoWinInfo.WIN5, 0),
            LottoResult(LottoWinInfo.WIN6, 0),
        )

        boughtLottos.forEach {
            val matchCount = getMatchCount(it, answer)

            val winnerInfo = LottoWinInfo.getWinnerInfo(matchCount) ?: return@forEach
            winnerInfos.first { info -> info.prize == winnerInfo }.also { prize ->
                prize.count++
                totalMoney += prize.prize.money
            }
        }

        return winnerInfos
    }

    private fun getMatchCount(list1: List<Int>, list2: List<Int>): Int {
        return list1.intersect(list2.toSet()).size
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}
