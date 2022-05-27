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
        var matchCount = 0
        luckyDrawNumber.forEach {
            matchCount = numbers.addMatchCountOrNull(it, matchCount)
        }
        return matchCount
    }

    private fun List<Int>.addMatchCountOrNull(input: Int, matchCount: Int): Int =
        if (this.contains(input)) matchCount + 1 else matchCount

    private fun plusCount(result: Int) {
        when (result) {
            THREE -> {
                three++
                this.result = this.result + DrawNumberEnum.THREE.amount
            }
            FOUR -> {
                four++
                this.result = this.result + result + DrawNumberEnum.FOUR.amount
            }
            FIVE -> {
                five++
                this.result = this.result + result + DrawNumberEnum.FIVE.amount
            }
            SIX -> {
                six++
                this.result = this.result + result + DrawNumberEnum.SIX.amount
            }
            else -> none++
        }
    }

    companion object {
        private const val THREE = 3
        private const val FOUR = 4
        private const val FIVE = 5
        private const val SIX = 6
    }
}
