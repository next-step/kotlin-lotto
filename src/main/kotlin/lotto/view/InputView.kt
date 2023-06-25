package lotto.view

class InputView {
    fun inputSeedMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLotto(): List<Set<Int>> {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualLottoCount = readln().toInt()

        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualLottoCount) { inputNumbers() }
    }

    fun inputWinningNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return inputNumbers()
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    private fun inputNumbers(): Set<Int> {
        return readln().split(",").map { it.trim().toInt() }.toSet()
    }
}
