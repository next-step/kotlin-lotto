package lotto

object InputView {

    fun requestPurchaseAmount(): Int {
        printMessage("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun requestLastWinnerNumbers(): List<Int> {
        printMessage("\n지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map {
            it.trim().toInt()
        }
    }

    private fun printMessage(message: String) {
        println(message)
    }
}
