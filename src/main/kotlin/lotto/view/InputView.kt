package lotto.view

object InputView {
    private const val COMMA = ","
    private const val ONE = 1

    fun getBudget(): Int {
        var budget = readLine()

        while (budget.isNullOrBlank()) {
            budget = readLine()
        }

        return budget.toInt()
    }

    fun getManualCount(totalCount: Int): Int {
        var manualCount = readLine().trimAndToInt()

        while (isInvalidInput(manualCount, totalCount)) {
            manualCount = readLine().trimAndToInt()
        }

        return manualCount!!
    }

    fun getLottoNumbersByManual(count: Int): List<List<Int>> {
        return (ONE..count).map { readLottoNumbers() }
    }

    fun readLottoNumbers(): List<Int> {
        var winningNumbers = readLine()

        while (winningNumbers.isNullOrBlank()) {
            winningNumbers = readLine()
        }

        return winningNumbers
            .split(COMMA)
            .map { it.trim().toInt() }
    }

    fun readBonusNumber(): Int {
        var bonusNumber = readLine()

        while (bonusNumber.isNullOrBlank()) {
            bonusNumber = readLine()
        }

        return bonusNumber.toInt()
    }

    private fun String?.trimAndToInt(): Int? {
        return this?.trim()?.toInt()
    }

    private fun isInvalidInput(manualCount: Int?, totalCount: Int): Boolean {
        return manualCount == null || manualCount > totalCount
    }

    fun printManualCountQuestion() {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
    }

    fun printManualNumberQuestion() {
        println("수동으로 구매할 번호를 입력해 주세요.")
    }

    fun printBonusBallQuestion() {
        println("보너스 볼을 입력해 주세요.")
    }

    fun printBudgetQuestion() {
        println("구입금액을 입력해 주세요.")
    }

    fun printWinningNumberQuestion() {
        println("지난 주 당첨 번호를 입력해 주세요.")
    }
}
