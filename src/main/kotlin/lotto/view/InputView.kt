package lotto.view

object InputView {

    fun getAmount(): Int {
        println("구매 금액을 입력해주세요.")
        return read()
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        return read()
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return read()
    }

    fun getWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해주세요.")
        return getSplitList()
    }

    private fun getSplitList() = readLine()?.split(",")?.map { it.toInt() } ?: throw IllegalArgumentException()

    fun getManualLottoNumbers(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해주세요.")
        val lottoNumbers = mutableListOf<List<Int>>()
        repeat(count) {
            lottoNumbers.add(getSplitList())
        }
        return lottoNumbers
    }

    private fun read(): Int {
        return readLine()?.toInt() ?: throw NumberFormatException("숫자를 입력해주세요.")
    }
}
