package Calculator

object Calculator {

    fun calculate(numbers: List<Int>): Int {
        return numbers.sum()
    }

    fun getNumbers(numbersInput: String?): String? {
        require(!numbersInput.isNullOrBlank()) { NullPointerException("숫자를 입력해주세요.") }
        return numbersInput
    }
}
