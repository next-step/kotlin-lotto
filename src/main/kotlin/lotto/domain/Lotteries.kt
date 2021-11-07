package lotto.domain

@JvmInline
value class Lotteries private constructor(val values: List<Lottery>) {

    fun rank(winning: Lottery, bonusBall: BonusBall): List<Ranking> {
        return values.map { Ranking.calculate(it.drawLottery(winning), it.isContainBonusBall(bonusBall.value)) }
    }

    companion object {
        fun of(values: List<Lottery>): Lotteries {
            return Lotteries(values)
        }
    }
}
