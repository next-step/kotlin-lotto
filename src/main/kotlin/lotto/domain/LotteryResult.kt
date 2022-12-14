package lotto.domain

class LotteryResult(private val countSameLottoNumber: List<Int>) {

    fun matchCount(howMany: Int): Int {
        return countSameLottoNumber.count { it == howMany }
    }
}
