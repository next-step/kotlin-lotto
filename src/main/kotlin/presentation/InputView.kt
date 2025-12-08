package presentation

class InputView {
    companion object {
        fun inputPurchaseAmount(): Int {
            println("구입금액을 입력해 주세요.")
            return readInt()
        }

        fun inputManualLottoCount(purchaseLottoCount: Int): Int {
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            val manualLottoCount = readInt()
            require(manualLottoCount <= purchaseLottoCount) { "수동으로 구매할 로또 수는 로또 구매 갯수보다 작아야합니다. 로또 구매 갯수: $purchaseLottoCount 개" }
            return manualLottoCount
        }

        fun inputManualLottoNumbers(): List<Int> {
            return readIntList()
        }

        fun inputWinningNumbers(): List<Int> {
            println("지난 주 당첨번호를 입력해 주세요.")
            return readIntList()
        }

        fun inputBonusBallNumber(): Int {
            println("보너스 볼을 입력해 주세요.")
            return readInt()
        }

        private fun readInt(): Int = readln().toInt()

        private fun readIntList(): List<Int> = readln().split(",").map { it.trim().toInt() }
    }
}
