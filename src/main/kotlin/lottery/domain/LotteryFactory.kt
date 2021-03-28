package lottery.domain

import lottery.domain.Lottery.Companion.DEFAULT_LOTTO_PRICE

class LotteryFactory(private val inputPrice: Int, private val unitPrice: Int = DEFAULT_LOTTO_PRICE) {
    init {
        require(unitPrice in DEFAULT_LOTTO_PRICE until inputPrice) { "잘못된 금액을 입력하였습니다." }
    }

    fun buy(generator: NumbersGenerator): Lotteries {
        val count = calculateLotteryCountByPrice()

        val allNumbers = (START_LOTTERY_COUNT..count).map { generateLotteryNumbers(generator) }

        return Lotteries.of(allNumbers)
    }

    private fun generateLotteryNumbers(generator: NumbersGenerator): List<Int> {
        return generator.generate(MIN_LOTTERY_NUMBER, MAX_LOTTERY_NUMBER, LOTTERY_SIZE)
    }

    fun calculateLotteryCountByPrice(): Int {
        return inputPrice / unitPrice
    }

    companion object {
        private const val MIN_LOTTERY_NUMBER = 1
        private const val MAX_LOTTERY_NUMBER = 45
        private const val LOTTERY_SIZE = 6
        private const val START_LOTTERY_COUNT = 1
    }
}
