package lotto.view

object InputView {

    fun showAndGetPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun showAndGetManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun showAndGetManualLottoNumbers(count: Int): List<String> {
        if (count == 0) return listOf()
        val lottoNumbers = mutableListOf<String>()
        println("수동으로 구매할 번호를 입력해 주세요.")
        repeat(count) {
            lottoNumbers.add(readln())
        }

        return lottoNumbers
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
