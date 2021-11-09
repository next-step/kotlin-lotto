package lotto.domain

@JvmInline
value class Lottery private constructor(val numbers: LottoNumbers) {

    fun drawLottery(lottery: Lottery): Int {
        return numbers.countMatchedNumbers(lottery.numbers)
    }

    fun isContainBonusBall(bonusBall: BonusBall): Boolean {
        return bonusBall.isIn(numbers)
    }

    companion object {
        fun of(numbers: LottoNumbers): Lottery {
            return Lottery(numbers)
        }
    }
}
