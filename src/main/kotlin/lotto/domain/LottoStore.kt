package lotto.domain

class LottoStore(
    private val money: Money,
    manualCount: Int,
    private val lottoMaker: LottoMaker = KoreanLottoNumberMaker()
) {
    val autoLottoCount = money.getLottoCount() - manualCount

    private val _boughtLottos = MutableList(autoLottoCount) { lottoMaker.makeLottoNumbers() }
    val boughtMoney
        get() = _boughtLottos.toList()

    val totalYieldRatio
        get() = totalMoney.money.toDouble() / money.money
    private var totalMoney = Money()

    fun getLottoResult(answer: LottoNumbers, bonus: LottoNumber): List<LottoResult> {
        val lottoResult = LottoPrizeInfo.values().map { LottoResult(it) }

        _boughtLottos.forEach {
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
        _boughtLottos.addAll(lottoNumbers)
    }

    private fun addPrizeMoney(money: Money) {
        totalMoney += money
    }

    private fun isMatchBonus(bonusNumber: LottoNumber, answer: LottoNumbers): Boolean {
        return answer.hasNumber(bonusNumber)
    }
}
