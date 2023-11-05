package lotto

data class LottoNumbers(val numbers: List<LottoNumber>) {
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) })

    init {
        require(numbers.size == 6) {
            "number size must be 6"
        }

        require(numbers.distinct().size == 6) {
            "numbers should not contain duplicated number"
        }
    }

    fun getContainCount(winningNumbers: WinningNumbers): Int {
        var count = 0
        for (number in winningNumbers.winningNumbers.numbers) {
            if (numbers.contains(number)) count++
        }
        return count
    }
}
