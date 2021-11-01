package lotto.view

import lotto.dto.WinningLottoDto

object InputView {
    fun askPurchase(): Int {
        println("구입금액을 입력해주세요.")
        return readNumber()
    }

    fun askManualLottos(): List<List<Int>> {
        val number = askManualLottoNumber()
        println("\n수동으로 구매할 번호를 입력해 주세요.")
        return (1..number).map { readLottoNumbers() }
    }

    private fun askManualLottoNumber(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readNumber()
    }

    fun askWinningLotto(): WinningLottoDto {
        return WinningLottoDto(askWinningNumbers(), askBonus())
    }

    private fun askWinningNumbers(): List<Int> {
        println("\n지난주 당첨 번호를 입력해 주세요.")
        return readLottoNumbers()
    }

    private fun askBonus(): Int {
        println("보너스 볼을 입력해 주세요.")
        val input = readLine()
        require(!input.isNullOrBlank()) { "보너스 볼은 1과 45사이의 숫자이어야 합니다." }
        return input.toInt()
    }

    private fun readNumber(): Int {
        val input = readLine()
        require(!input.isNullOrBlank()) { "빈 값을 입력할 수는 없습니다." }
        val number = input.toInt()
        require(number >= 0) { "양수를 입력해야 합니다." }
        return number
    }

    private fun readLottoNumbers(): List<Int> {
        val input = readLine()
        require(!input.isNullOrBlank()) { "빈 값을 입력할 수는 없습니다." }
        val numbers = input.filterNot { it.isWhitespace() }
            .split(LOTTO_NUMBER_DELIMITER).map { it.toInt() }
        require(numbers.size == 6) { "로또 번호는 , 로 구분된 6개의 숫자이어야 합니다." }
        return numbers
    }

    private const val LOTTO_NUMBER_DELIMITER = ","
}
