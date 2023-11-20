package org.bmsk.domain.model.lotto

import org.bmsk.domain.model.random.LottoRandomGenerator
import org.bmsk.domain.model.random.RandomGenerator

class LotteryGenerator(
    private val randomGenerator: RandomGenerator = LottoRandomGenerator(),
) {
    fun generateByPrice(price: Int): List<LottoLottery> {
        val count = price / LottoLottery.DEFAULT_PRICE
        return generateByCount(count)
    }

    fun generateByCount(count: Int): List<LottoLottery> {
        val lotteries = mutableListOf<LottoLottery>()

        repeat(count) {
            lotteries.add(generate())
        }
        return lotteries.toList()
    }

    private fun generate(): LottoLottery {
        val numbers = mutableListOf<Int>()
        repeat(LottoLottery.LOTTO_NUMBER_SIZE) {
            val randomNumber = randomGenerator.generate(exceptionNumbers = numbers)
            numbers.add(randomNumber)
        }
        return LottoLottery(numbers = numbers.toList())
    }
}
