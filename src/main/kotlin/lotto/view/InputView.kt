package lotto.view

/**
 * 로또 실행시, 입력받는 뷰
 * */
class InputView {
    fun takePurchasedPrice(): Int? {
        println("구입금액을 입력해 주세요.")
        return readLine()?.toIntOrNull()
    }

    fun inputLastLottoWinNumber(): String? {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLine()
    }

    fun inputBonusNumber(): Int? {
        println("보너스 볼을 입력해 주세요.")
        return readLine()?.toIntOrNull()
    }

    fun inputManualLottoCount(): Int? {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readLine()?.toIntOrNull()
    }

    fun inputManualLottoNumber(count: Int): List<String?> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualLottoLists = mutableListOf<String?>()
        repeat(count) {
            val inputManualLottoNumber = readLine()
            manualLottoLists.add(inputManualLottoNumber)
        }
        return manualLottoLists
    }
}
