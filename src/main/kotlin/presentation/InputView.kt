package presentation

class InputView {
    companion object {
        fun inputPurchaseAmount(): String {
            println("구입금액을 입력해 주세요.")
            return readln()
        }

        fun inputWinningNumbers(): List<Int> {
            println("지난 주 당첨번호를 입력해 주세요.")
            return readln().split(",").map { it.trim().toInt() }
        }
    }
}
