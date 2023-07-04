package lottery.domain

class WinningLottery(numbers: Set<LotteryNumber>) {
    val winningNumbers: Set<LotteryNumber>

    init {
        require(!hasDuplicatedLotteryNumbers(numbers)) { "로또 번호에 중복되는 숫자가 있습니다." }
        winningNumbers = numbers
    }

    private fun hasDuplicatedLotteryNumbers(numbers: Set<LotteryNumber>): Boolean {
        return numbers.size != Lottery.LOTTERY_NUMBER_SIZE
    }
}
