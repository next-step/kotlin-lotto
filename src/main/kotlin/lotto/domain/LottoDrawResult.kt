package lotto.domain

import lotto.domain.dto.DrawNumberEnum
import lotto.domain.dto.LottoNumber

class LottoDrawResult(private val luckyDrawNumber: List<Int>) {
    val getThree
        get() = this.three
    val getFour
        get() = this.four
    val getFive
        get() = this.five
    val getSix
        get() = this.six
    val getResult
        get() = this.result
    private var result: Long = 0
    private var three: Int = 0
    private var four: Int = 0
    private var five: Int = 0
    private var six = 0
    private var none: Int = 0

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
            DrawNumberEnum.THREE.count -> {
                three++
                this.result = this.result + DrawNumberEnum.THREE.amount
            }
            DrawNumberEnum.FOUR.count -> {
                four++
                this.result = this.result + DrawNumberEnum.FOUR.amount
            }
            DrawNumberEnum.FIVE.count -> {
                five++
                this.result = this.result + DrawNumberEnum.FIVE.amount
            }
            DrawNumberEnum.SIX.count -> {
                six++
                this.result = this.result + DrawNumberEnum.SIX.amount
            }
            else -> none++
        }
    }
}
