package lotto

object LottoGameReader {
    fun readAmount(): Int {
        LottoGamePrinter.printAmountMessage()
        return readNumber()
    }

    fun readWinningLottoNumbers(): Set<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return ConsoleReader.readLine().split(",")
            .map { number -> number.trim().toIntOrNull() ?: throw IllegalArgumentException("당첨 번호는 숫자만 입력해야 합니다.") }
            .toSet()
    }

    private fun readNumber(): Int {
        val number = ConsoleReader.readLine().trim().toIntOrNull()
        requireNotNull(number) { "숫자만 입력해야 합니다. 현재 입력 = $number" }
        return number
    }
}