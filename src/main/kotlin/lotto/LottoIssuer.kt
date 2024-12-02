package lotto

object LottoIssuer {
    private const val LOTTO_MONEY = 1_000
    private val LOTTO_RANGE = 1..45

    fun issue(
        money: Money,
        manualNumbers: List<String>
    ): List<LottoNumbers> {
        val manualLottoMoney = manualNumbers.size * LOTTO_MONEY
        val remainingMoney = money - manualLottoMoney
        val autoLottoCount = remainingMoney.value / LOTTO_MONEY

        val autoLottoNumbers = List(autoLottoCount) { LottoNumbers.generate(LOTTO_RANGE) }
        val manualLottoNumbers = getManualLottoNumbers(manualNumbers)

        return manualLottoNumbers + autoLottoNumbers
    }

    private fun getManualLottoNumbers(manualLottoNumbers: List<String>) =
        manualLottoNumbers.map { LottoNumbers.created(it.split(", ").map { it.toInt() }) }
}
