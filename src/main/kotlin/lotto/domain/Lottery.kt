package lotto.domain

@JvmInline
value class Lottery private constructor(val numbers: LottoNumbers) {

    fun drawLottery(lottery: Lottery): Int {
        return numbers.countMatchedNumbers(lottery.numbers)
    }

    fun isContainBall(number: LottoNumber): Boolean {
        return numbers.isContainLottoNumber(number)
    }

    companion object {
        fun of(numbers: LottoNumbers): Lottery {
            return Lottery(numbers)
        }
    }
}
