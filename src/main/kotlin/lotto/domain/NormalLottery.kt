package lotto.domain

import lotto.infra.port.NumberGenerator
import lotto.vo.LottoScore

class NormalLottery(numbers: List<Int>) : Lottery<NormalLottery>(numbers) {

    override fun toString(): String = numbers.toString()

    override fun match(other: NormalLottery): LottoScore = LottoScore.of(countingMatchNumber(other))

    private fun countingMatchNumber(other: NormalLottery): Int = numbers.count(other.numbers::contains)

    companion object {

        fun createRandomNumbers(numberGenerator: NumberGenerator<List<Int>>): NormalLottery {
            return NormalLottery(numberGenerator.generate())
        }
    }
}
