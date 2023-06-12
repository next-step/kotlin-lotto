package lottery.domain.lottery

import lottery.domain.Rank

class Lottery(
    val values: List<LotteryNumber>
) : List<LotteryNumber> by values {
    init {
        require(values.size == LOTTERY_NUMBER_SIZE) { "로또 번호는 6개만 입력하여야한다" }
        require(values.distinct().size == LOTTERY_NUMBER_SIZE) { "로또 번호는 중복되어 입력될 수 없다" }
    }

    fun compareWinningLottery(lottery: Lottery) = Rank.from(values.count { lottery.values.contains(it) })

    fun toLotteryNumbers() = values.map { it.value }

    companion object {
        const val LOTTERY_NUMBER_SIZE = 6

        fun from(values: List<String>) = Lottery(values.map { LotteryNumber.from(it) })
    }
}
