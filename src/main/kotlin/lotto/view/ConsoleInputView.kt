package lotto.view

class ConsoleInputView : InputView {
    override fun requestPrice(): Int {
        println("구입금액을 입력해 주세요.")
        val price = readInput()

        return price.toInt()
    }

    override fun requestManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualCount = readInput()

        return manualCount.toInt()
    }

    override fun requestManualLottoNumbers(count: Int): List<List<Int>> {
        if (count == 0) {
            return emptyList()
        }

        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map {
            val numbers = readInput()

            numbers.split(DELIMITER)
                .map { it.trim().toInt() }
        }
    }

    override fun requestWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = readInput()

        return numbers.split(DELIMITER)
            .map { it.trim().toInt() }
    }

    override fun requestBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readInput()

        return bonusNumber.toInt()
    }

    private fun readInput(): String {
        return readInput()
    }

    companion object {
        private const val DELIMITER = ","
    }
}
