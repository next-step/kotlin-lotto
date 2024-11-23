package lottery

data class LotteryNumbers(val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개이어야 합니다" }
        require(numbers.distinct().size == numbers.size) { "로또 번호는 중복될 수 없습니다" }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이어야 합니다" }
    }

    fun countMatchedNumber(numbers: List<Int>): Int {
        return this.numbers.intersect(numbers.toSet()).size
    }

    companion object {
        fun create(): LotteryNumbers {
            val numbers = (1..45).shuffled().take(6).sorted()
            return LotteryNumbers(numbers)
        }
    }
}
