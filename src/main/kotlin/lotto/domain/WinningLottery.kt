package lotto.domain

class WinningLottery(private val lottery: Lottery, private val bonusBall: LottoNumber) {

    init {
        verify(lottery, bonusBall)
    }

    private fun verify(lottery: Lottery, bonusBall: LottoNumber) {
        require(!lottery.isContainBall(bonusBall)) { "보너스 볼은 당첨번호에 포함된 번호일 수 없습니다." }
    }

    fun rank(lotteries: Lotteries): List<Ranking> {
        return lotteries.values.map { Ranking.calculate(it.drawLottery(lottery), it.isContainBall(bonusBall)) }
    }

    companion object {
        fun of(lottery: Lottery, bonusBall: LottoNumber): WinningLottery {
            return WinningLottery(lottery, bonusBall)
        }

        fun of(lottoNumbers: LottoNumbers, bonusBall: LottoNumber): WinningLottery {
            return of(Lottery.of(lottoNumbers), bonusBall)
        }

        fun of(numbers: List<Int>, bonusBall: LottoNumber): WinningLottery {
            return numbers.map { LottoNumber.of(it) }
                .run { LottoNumbers.of(this) }
                .run { of(this, bonusBall) }
        }
    }
}
