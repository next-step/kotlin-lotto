package lotto.domain

class LottoStore(
    private val money: Money,
    private val manualCount: Int,
    private val lottoMaker: LottoMaker = KoreanLottoNumberMaker()
) {
    val autoLottoCount = money.getLottoCount() - manualCount

    // val boughtLottos = List(lottoCount) { lottoMaker.makeLottoNumbers() }
    val boughtLottos = mutableListOf<LottoNumbers>()
    val totalYieldRatio
        get() = totalMoney.money.toDouble() / money.money
    private var totalMoney = Money()

    fun getLottoResult(answer: LottoNumbers, bonus: LottoNumber): List<LottoResult> {
        val lottoResult = LottoPrizeInfo.values().map { LottoResult(it) }

        boughtLottos.forEach {
            val matchCount = it.intersectCount(answer)
            val matchBonus = isMatchBonus(bonus, answer)

            val prizeInfo = LottoPrizeInfo.getPrizeInfo(matchCount, matchBonus) ?: return@forEach
            lottoResult.first { info -> info.prize == prizeInfo }.also { prize ->
                prize.increaseMatchCount()

                addPrizeMoney(prize.getPrizeMoney())
            }
        }

        return lottoResult
    }

    fun buyManualLottos(lottoNumbers: List<LottoNumbers>) {
        boughtLottos.addAll(lottoNumbers)
    }

    fun rollAutoLotto() {
        repeat(autoLottoCount) {
            boughtLottos.add(lottoMaker.makeLottoNumbers())
        }
    }

    private fun addPrizeMoney(money: Money) {
        totalMoney += money
    }

    private fun isMatchBonus(bonusNumber: LottoNumber, answer: LottoNumbers): Boolean {
        return answer.hasNumber(bonusNumber)
    }
}
