package lotto.view

object InputView {

    fun purchasePrice(): Int {

        println("구입금액을 입력해 주세요.")
        val price = readLine()

        return price!!.toInt()
    }

    fun askWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine() ?: throw IllegalArgumentException()
    }

    fun askBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readLine() ?: throw IllegalArgumentException()
        return bonusNumber.toInt()
    }
}
