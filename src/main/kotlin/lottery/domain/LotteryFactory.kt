package lottery.domain

import lottery.domain.Lottery.Companion.DEFAULT_LOTTO_PRICE

class LotteryFactory(private val inputPrice: Int, private val unitPrice: Int = DEFAULT_LOTTO_PRICE) {
    init {
        require(unitPrice in DEFAULT_LOTTO_PRICE until inputPrice) { "잘못된 금액을 입력하였습니다." }
    }

    fun buy(generator: NumbersGenerator, manualLotteryNumbers: List<List<Int>>): Lotteries {
        val count = calculateLotteryCountByPrice()

        val countOfAutoLottery = calculateAutoLotteryCount(count, manualLotteryNumbers.size)

        val autoLotteryNumbers = generateAutoLotteryNumbers(countOfAutoLottery, generator)

        val allLotteryNumbers = merge(autoLotteryNumbers, manualLotteryNumbers)

        return Lotteries.of(allLotteryNumbers)
    }

    private fun merge(firstNumbers: List<List<Int>>, secondNumbers: List<List<Int>>): List<List<Int>> {
        return firstNumbers.plus(secondNumbers)
    }

    private fun generateAutoLotteryNumbers(
        countOfAutoLottery: Int,
        generator: NumbersGenerator
    ): List<List<Int>> = (START_LOTTERY_COUNT..countOfAutoLottery).map { generateLotteryNumbers(generator) }

    fun calculateAutoLotteryCount(
        allLotteryCount: Int,
        manualLotteryCount: Int
    ) = allLotteryCount - manualLotteryCount

    fun calculateLotteryCountByPrice(): Int {
        return (inputPrice / unitPrice)
    }

    private fun generateLotteryNumbers(generator: NumbersGenerator): List<Int> {
        return generator.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_SIZE)
    }

    companion object {
        private const val MIN_LOTTERY_NUMBER = 1
        private const val MAX_LOTTERY_NUMBER = 45
        private const val LOTTERY_SIZE = 6
        private const val START_LOTTERY_COUNT = 1
    }
}
