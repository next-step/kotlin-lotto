package lotto

object LottoProgram {
    private const val UNIT = 1000
    fun getAmountOfLotto(amountOfMoney: Int): Int {
        validateMoneyUnit(amountOfMoney)
        return amountOfMoney / UNIT
    }

    private fun validateMoneyUnit(amountOfMoney: Int) {
        if (amountOfMoney % UNIT != 0 || amountOfMoney == 0) {
            throw UnitException("1000원 단위만 입력할 수 있습니다.")
        }
    }
}
