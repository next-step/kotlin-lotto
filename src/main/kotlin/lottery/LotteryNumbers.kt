package lottery

class LotteryNumbers(val numbers: Set<Int>) {
    init {
        require(numbers.size == 6) { "로또 번호는 6개이어야 합니다" }
        require(numbers.all { it in 1..45 }) { "로또 번호는 1부터 45 사이어야 합니다" }
    }

    fun countMatchedNumber(other: LotteryNumbers): Int {
        return this.numbers.intersect(other.numbers).size
    }

    companion object {
        fun create(): LotteryNumbers {
            val numbers = (1..45).shuffled().take(6).sorted().toSet()
            return LotteryNumbers(numbers)
        }
    }
}
