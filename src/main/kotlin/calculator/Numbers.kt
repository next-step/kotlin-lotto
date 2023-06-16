package calculator

data class Numbers(private val numbers: List<Int>) {
    init {
        require(numbers.all { it >= 0 }) { "음수가 전달되었습니다." }
    }

    fun sum(): Int {
        return numbers.sum()
    }
}
