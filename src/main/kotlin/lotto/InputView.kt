package lotto

object InputView {
    fun inputPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()!!.split(",").map { it.trim().toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readLine()!!.toInt()
    }

    fun issueManualLottoNumbers(): List<List<Int>> {
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualLottoCount = readLine()!!.toInt()
        println()
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..manualLottoCount).map {
            readLine()!!.split(",").map { it.trim().toInt() }
        }
    }
}
