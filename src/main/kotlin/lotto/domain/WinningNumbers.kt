package lotto.domain

class WinningNumbers(numbers: List<Int>) {
    val numbers = numbers.map(::LottoNumber)

    init {
        require(numbers.size == 6 && numbers.toSet().size == 6) { "당첨번호는 중복되지 않는 6개의 숫자가 있어야합니다." }
    }

    companion object {
        // ex ) 1,2,3,4,5,6
        fun fromCSV(string: String): WinningNumbers {
            val strings = string.replace(" ", "").split(",")
            return WinningNumbers(strings.map(String::toInt))
        }
    }
}
