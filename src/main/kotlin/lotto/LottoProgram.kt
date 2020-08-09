package lotto

object LottoProgram {
    private const val UNIT = 1000

    fun getAmountOfLotto(amountOfMoney: Int): Int {
        validateMoneyUnit(amountOfMoney)
        return amountOfMoney / UNIT
    }

    fun getWinningNumbers(winningNumbers: String): WinningNumbers {
        val numbers = winningNumbers.replace(" ", "")
            .split(",")
            .map { it.toInt() }
        validateDuplicatedNumber(numbers)
        return WinningNumbers(numbers)
    }

    private fun validateDuplicatedNumber(numbers: List<Int>) {
        if (numbers.distinct().size != numbers.size) {
            throw IllegalArgumentException("중복된 숫자는 입력할 수 없습니다.")
        }
    }

    private fun matchLotto(userLotto: Lotto, winningLotto: List<Int>): Int {
        return userLotto.lotto.filter { winningLotto.contains(it) }.count()
    }

    private fun validateMoneyUnit(amountOfMoney: Int) {
        if (amountOfMoney % UNIT != 0 || amountOfMoney == 0) {
            throw UnitException("1000원 단위만 입력할 수 있습니다.")
        }
    }
}
