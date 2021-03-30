package lottery.domain

class LotteryFactory(private val inputPrice: Int, private val unitPrice: Int = DEFAULT_LOTTO_PRICE) {
    init {
        require(unitPrice in DEFAULT_LOTTO_PRICE until inputPrice) { "잘못된 금액을 입력하였습니다." }
    }

    fun buy(generator: NumbersGenerator, manualLotteryNumbers: Numbers): Lotteries {
        val count = calculateLotteryCountByPrice()

        val countOfAutoLottery = calculateAutoLotteryCount(count, manualLotteryNumbers.size)

        val autoLotteryNumbers = generateAutoLotteryNumbers(countOfAutoLottery, generator)

        val allLotteryNumbers = manualLotteryNumbers.merge(autoLotteryNumbers)

        return Lotteries.of(allLotteryNumbers)
    }

    private fun generateAutoLotteryNumbers(countOfAutoLottery: Int, generator: NumbersGenerator): Numbers {
        return Numbers((START_LOTTERY_COUNT..countOfAutoLottery).map { generateLotteryNumbers(generator) })
    }

    fun calculateAutoLotteryCount(
        allLotteryCount: Int,
        manualLotteryCount: Int
    ) = allLotteryCount - manualLotteryCount

    fun calculateLotteryCountByPrice(): Int {
        return (inputPrice / unitPrice)
    }

    private fun generateLotteryNumbers(generator: NumbersGenerator): LotteryNumbers {
        return LotteryNumbers(generator.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_SIZE))
    }

    companion object {
        private const val MIN_LOTTERY_NUMBER = 1
        private const val MAX_LOTTERY_NUMBER = 45
        private const val LOTTERY_SIZE = 6
        private const val START_LOTTERY_COUNT = 1
        private const val DEFAULT_LOTTO_PRICE = 1000
    }
}
