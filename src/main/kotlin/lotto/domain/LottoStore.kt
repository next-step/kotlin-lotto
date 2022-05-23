package lotto.domain

class LottoStore(private val money: Int, private val lottoMaker: LottoMaker = KoreanLottoNumberMaker()) {
    val lottoCount = money / EACH_LOTTO_PRICE
    val boughtLottos = mutableListOf<List<Int>>()
    val totalYieldRatio
        get() = totalMoney.toDouble() / money
    private var totalMoney = 0

    init {
        repeat(lottoCount) {
            boughtLottos.add(lottoMaker.makeLottoNumbers())
        }
    }

    fun getLottoResult(answer: List<Int>): List<LottoResult> {
        val lottoResult = listOf(
            LottoResult(LottoPrizeInfo.WIN3),
            LottoResult(LottoPrizeInfo.WIN4),
            LottoResult(LottoPrizeInfo.WIN5),
            LottoResult(LottoPrizeInfo.WIN6),
        )

        boughtLottos.forEach {
            val matchCount = getMatchCount(it, answer)

            val prizeInfo = LottoPrizeInfo.getPrizeInfo(matchCount) ?: return@forEach
            lottoResult.first { info -> info.prize == prizeInfo }.also { prize ->
                prize.count++
                totalMoney += prize.prize.money
            }
        }

        return lottoResult
    }

    private fun getMatchCount(list1: List<Int>, list2: List<Int>): Int {
        return list1.intersect(list2.toSet()).size
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}
