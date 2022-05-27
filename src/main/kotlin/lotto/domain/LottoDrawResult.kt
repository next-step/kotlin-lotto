package lotto.domain

import lotto.domain.dto.Rank
import lotto.domain.dto.LottoNumber

class LottoDrawResult(private val luckyDrawNumber: List<Int>) {
    var result: Long = 0
        private set
    var three: Int = 0
        private set
    var four: Int = 0
        private set
    var five: Int = 0
        private set
    var six = 0
        private set
    var none: Int = 0

    fun draw(lottoList: List<LottoNumber>) {
        lottoList.forEach {
            this.plusCount(checkDrawResult(it))
        }
    }

    private fun checkDrawResult(lottoNumber: LottoNumber): Int {
        val numbers = lottoNumber.numbers
        return luckyDrawNumber.count { numbers.contains(it) }
    }

    private fun plusCount(result: Int) {
        when (result) {
            Rank.FOURTH.count -> {
                three++
                this.result = this.result + Rank.FOURTH.amount
            }
            Rank.THIRD.count -> {
                four++
                this.result = this.result + Rank.THIRD.amount
            }
            Rank.SECOND.count -> {
                five++
                this.result = this.result + Rank.SECOND.amount
            }
            Rank.FIRST.count -> {
                six++
                this.result = this.result + Rank.FIRST.amount
            }
            else -> none++
        }
    }
}
