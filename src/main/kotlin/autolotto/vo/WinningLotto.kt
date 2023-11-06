package autolotto.vo

class WinningLotto(input: String) {
    val numbers: List<Int>

    init {
        numbers = convertToNumbers(input)
        require(numbers.isNotEmpty()) { "당첨 번호는 비어있을 수 없습니다." }
        require(numbers.size == 6) { "당첨 번호는 6개여야 합니다." }
        require(numbers.distinct().size == 6) { "당첨 번호는 중복되지 않아야 합니다." }
        require(numbers.all { it in 1..45 }) { "당첨 번호는 1~45 사이여야 합니다." }
    }

    private fun convertToNumbers(input: String): List<Int> {
        return input.split(",").map { it.trim() }
            .map {
                try {
                    it.toInt()
                } catch (e: NumberFormatException) {
                    throw IllegalArgumentException("당첨 번호는 숫자여야 합니다.")
                }
            }
    }
}
