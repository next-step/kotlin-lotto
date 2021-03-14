package lotto.ui

class InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputNumberOfManual(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요")
        return readLine()!!.toInt()
    }

    fun inputManualNumbers(numberOfManual: Int): List<List<String>> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        val manuals = mutableListOf<String>()
        repeat(numberOfManual) {
            readLine()?.let { string -> manuals.add(string) }
        }
        return manuals.map {
            it.split(", ")
        }
    }

    fun inputPrizeNumber(): List<String> {
        println("\n지난 주 당첨 번호를 입력해 주세요")
        return readLine()!!.split(", ")
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }
}
