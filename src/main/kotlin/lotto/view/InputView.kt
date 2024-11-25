package lotto.view

object InputView {

    fun showAndGetPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun showAndGetTargetLotto(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun showAndGetBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

}
