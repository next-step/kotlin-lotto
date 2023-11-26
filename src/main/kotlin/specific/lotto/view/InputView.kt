package specific.lotto.view

object InputView {
    fun getMoney(): String? {
        println("구입금액을 입력해 주세요.")
        return readlnOrNull()
    }

    fun getManualLottoCount(): String? {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readlnOrNull()
    }

    fun getManualNumbers(): String? {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return readlnOrNull()
    }

    fun getMainNumbers(): String? {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readlnOrNull()
    }

    fun getBonusNumber(): String? {
        println("보너스 볼을 입력해 주세요.")
        return readlnOrNull()
    }

}
