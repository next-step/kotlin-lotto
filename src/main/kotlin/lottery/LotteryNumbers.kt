package lottery

data class LotteryNumbers(val numbers: List<Int>) {
    companion object {
        fun create(): LotteryNumbers {
            val numbers = (1..45).shuffled().take(6).sorted()
            return LotteryNumbers(numbers)
        }
    }
}
