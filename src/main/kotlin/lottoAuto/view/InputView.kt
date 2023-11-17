package lottoAuto.view

object InputView {
    fun getPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val purchaseAmount = readln().toInt()
        require(purchaseAmount > 0) { "구입 금액은 0보다 커야합니다." }
        return purchaseAmount
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    fun getWinningNumbers(): List<Int> {
        println("\n지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(",").map { it.trim().toInt() }
    }
}
