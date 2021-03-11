package domain

class LotteryNumbers(numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "숫자는 6개 이상이여야 합니다." }
    }
}
