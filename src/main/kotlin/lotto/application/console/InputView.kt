package lotto.application.console

object InputView {

    private const val NUMBER_DELIMITER = ","

    fun inputCost(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLottos(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(count) { readLottoNumbers() }
    }

    fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readLottoNumbers()
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")
        return readln().toInt()
    }

    private fun readLottoNumbers(): List<Int> {
        return parseLottoNumber(readln())
    }

    private fun parseLottoNumber(values: String): List<Int> {
        return values.split(NUMBER_DELIMITER).map { it.trim().toInt() }
    }
}
