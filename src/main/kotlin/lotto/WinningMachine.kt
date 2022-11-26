package lotto

class WinningMachine(winningString: String) {

    val winningNumbers: List<Int>

    init {
        val stringNumbers = winningString.split(",")
        require(stringNumbers.isNotEmpty()) { "input string delimiter" }
        require(stringNumbers.size == Const.LOTTO_NUMBERS_COUNT) { "input string delimiter count" }

        this.winningNumbers = stringNumbers.map { numberString -> numberString.trim().toInt() }
            .filterNot { number -> number > Const.LOTTO_MAX_RANDOM_VALUE || number <= 0 }

        require(this.winningNumbers.size == 6) { "input string numbers range" }
    }
}
