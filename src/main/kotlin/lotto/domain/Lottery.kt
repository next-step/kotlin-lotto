package lotto.domain

@JvmInline
value class Lottery private constructor(val numbers: LottoNumbers) {
    fun drawLottery(lottery: Lottery): Int {
        return numbers.values.count { lottery.numbers.values.contains(it) }
    }

    fun isContainBonusBall(bonusBall: LottoNumber): Boolean {
        return numbers.isContainLottoNumber(bonusBall)
    }

    companion object {
        fun of(numbers: LottoNumbers): Lottery {
            return Lottery(numbers)
        }
    }
}
