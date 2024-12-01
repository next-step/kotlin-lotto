package lotto

object LottoIssuer {
    private const val MIN_PRICE = 1_000
    private val LOTTO_RANGE = 1..45

    fun issue(
        money: Money,
        manualNumbers: List<String>
    ): List<LottoNumbers> {
        val manualLottoCount = manualNumbers.size * MIN_PRICE
        val remainingMoney = money.minus(manualLottoCount)
        val autoLottoCount = remainingMoney.value / MIN_PRICE

        val autoLottoNumbers = List(autoLottoCount) { LottoNumbers.generate(LOTTO_RANGE) }
        val manualLottoNumbers = getManualLottoNumbers(manualNumbers)

        return merge(manualLottoNumbers, autoLottoNumbers)
    }

    private fun merge(
        manualLottoNumbers: List<LottoNumbers>,
        autoLottoNumbers: List<LottoNumbers>
    ) = (manualLottoNumbers + autoLottoNumbers).toList()

    private fun getManualLottoNumbers(manualLottoNumbers: List<String>) =
        manualLottoNumbers.map { LottoNumbers.created(it.split(", ").map { it.toInt() }) }
}
