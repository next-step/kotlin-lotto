package presentation

class InputView {
    companion object {
        fun inputPurchaseAmount(): Int {
            println("구입금액을 입력해 주세요.")
            return readln().toInt()
        }

        fun inputManualLottoCount(purchaseLottoCount: Int): Int {
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            val manualLottoCount = readln().toInt()
            require(manualLottoCount <= purchaseLottoCount) { "수동으로 구매할 로또 수는 로또 구매 갯수보다 작아야합니다. 로또 구매 갯수: $purchaseLottoCount 개" }
            return manualLottoCount
        }

        fun inputWinningNumbers(): List<Int> {
            println("지난 주 당첨번호를 입력해 주세요.")
            val winningNumbers = readln().split(",").map { it.trim().toInt() }
            require(winningNumbers.toSet().size == 6) { "당첨번호는 중복 없는 6자리 숫자여야합니다." }
            require(winningNumbers.all { it in 1..45 }) { "당첨번호는 1~45 사이의 숫자여야 합니다." }
            return winningNumbers
        }
    }
}
