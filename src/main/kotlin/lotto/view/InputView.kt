package lotto.view

import lotto.Lotto

object InputView {
    fun getTotalPrice(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun getManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해주세요.")
        val input = readln().toInt()
        require(input >= 0) { "수동으로 구매할 로또의 갯수는 0 이상의 숫자여야합니다." }
        return input
    }

    fun getManualLottoNumbers(manualLottoCount: Int): List<List<Int>> {
        require(manualLottoCount >= 0) { "수동으로 구매할 로또의 갯수는 0 이상의 숫자여야합니다." }

        if (manualLottoCount == 0) {
            return emptyList()
        }

        println("수동으로 구매할 번호를 입력해 주세요.")
        return (0 until manualLottoCount).map {
            splitLottoNumbers(readln())
        }
    }

    fun getPrevWeekWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return splitLottoNumbers(readln())
    }

    private fun splitLottoNumbers(input: String): List<Int> {
        val numbers = input.split(", ").map { it.toInt() }
        require(numbers.size == Lotto.MAX_NUMBER_COUNT) { "당첨 번호는 정확히 6개여야합니다." }
        return numbers
    }

    fun getBonusNumber(): Int {
        println("보너스 볼을 입력해주세요.")
        val input = readln()
        return input.toInt()
    }
}
