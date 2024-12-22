package lotto.view.keyboard

class MachineKeyboard : Keyboard {
    override fun inputLottoPrice(): Int {
        val input = readlnOrNull()?.toIntOrNull()
        require(input != null && input > 0) { "구입금액이 잘못 입력되었습니다" }
        return input
    }

    override fun inputLastWeekWinningNumbers(): List<Int> {
        val input = readlnOrNull()
        require(!input.isNullOrEmpty()) { "당첨 번호 입력이 잘못되었습니다." }
        return parseLottoNumbers(input)
    }

    private fun parseLottoNumbers(input: String): List<Int> {
        return input.split(",")
            .map(::validateAndParseNumber)
    }

    private fun validateAndParseNumber(numberString: String): Int {
        val number = numberString.trim().toIntOrNull()
        require(number != null) { "당첨 번호 입력이 잘못되었습니다." }
        return number
    }
}
