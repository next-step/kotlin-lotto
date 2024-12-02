package lotto

object InputView {
    fun getPurchaseMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getLottoNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(", ").map { it.toInt() }
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoCount(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoNumbers(manualLottoCount: Int): List<String> {
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return List(manualLottoCount) { readln() }
    }
}
