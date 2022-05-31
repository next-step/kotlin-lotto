package lotto.domain

class LottoStore(
    private val money: Money,
    manualLottos: List<LottoNumbers>,
    autoLottos: List<LottoNumbers>
) {
    private val _boughtLottos = manualLottos + autoLottos

    val boughtLottos
        get() = _boughtLottos.toList()

    val totalYieldRatio
        get() = totalMoney.money.toDouble() / money.money
    private var totalMoney = Money()

    fun getLottoResult(answer: LottoNumbers, bonus: LottoNumber): List<LottoResult> {
        val lottoResult = LottoPrizeInfo.getEmptyResult()

        _boughtLottos.forEach {
            val matchCount = it.intersectCount(answer)
            val matchBonus = answer.hasNumber(bonus)

            val prizeInfo = LottoPrizeInfo.getPrizeInfo(matchCount, matchBonus) ?: return@forEach
            lottoResult.first { info -> info.prize == prizeInfo }.also { prize ->
                prize.increaseMatchCount()

                addPrizeMoney(prize.getPrizeMoney())
            }
        }

        return lottoResult
    }

    private fun addPrizeMoney(money: Money) {
        totalMoney += money
    }
}
