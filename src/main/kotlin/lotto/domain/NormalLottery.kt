package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LotteryRank

class NormalLottery(numbers: List<Int>) : Lottery<NormalLottery>(numbers) {

    override fun toString(): String = numbers.toString()

    override fun match(other: NormalLottery): LotteryRank = LotteryRank.of(countingMatchNumber(other))

    companion object {

        fun createRandomNumbers(numberGenerator: NumberGenerator<List<Int>>): NormalLottery {
            return NormalLottery(numberGenerator.generate())
        }
    }
}
