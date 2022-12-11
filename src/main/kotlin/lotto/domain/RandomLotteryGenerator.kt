package lotto.domain

object RandomLotteryGenerator {

    fun run(): Lottery {
        val numbers = LotteryNumber
            .RANGE
            .shuffled()
            .subList(0, Lottery.SIZE_OF_LOTTO_NUMBERS)
            .sorted()

        return Lottery(
            numbers.map { number ->
                LotteryNumber(number)
            }
        )
    }
}
