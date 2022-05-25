package lotto.domain

class LottoStore(private val userMoney: UserMoney, private val lottoMaker: LottoMaker = KoreanLottoNumberMaker()) {
    val lottoCount = userMoney.money / EACH_LOTTO_PRICE
    val boughtLottos = List(lottoCount) { lottoMaker.makeLottoNumbers() }
    val totalYieldRatio
        get() = totalMoney.toDouble() / userMoney.money
    private var totalMoney = 0

    fun getLottoResult(answer: LottoNumbers, bonus: LottoNumber): List<LottoResult> {
        val lottoResult = LottoPrizeInfo.values().map { LottoResult(it) }

        boughtLottos.forEach {
            val matchCount = getMatchCount(it, answer)
            val matchBonus = isMatchBonus(bonus, answer)

            val prizeInfo = LottoPrizeInfo.getPrizeInfo(matchCount, matchBonus) ?: return@forEach
            lottoResult.first { info -> info.prize == prizeInfo }.also { prize ->
                prize.increaseMatchCount()

                addPrizeMoney(prize.getPrizeMoney())
            }
        }

        return lottoResult
    }

    private fun addPrizeMoney(money: Int) {
        totalMoney += money
    }

    private fun getMatchCount(lotto1: LottoNumbers, lotto2: LottoNumbers): Int {
        return lotto1.intersectCount(lotto2)
    }

    private fun isMatchBonus(bonusNumber: LottoNumber, answer: LottoNumbers): Boolean {
        return answer.hasNumber(bonusNumber)
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}
