package lotto

data class WinPolicy(val matchCount: Int, val priceAmount: Money) {
    fun isMatch(winNumbers: WinNumbers, lotto: Lotto): Boolean {
        return true
    }

    init {
        require(1 <= matchCount) { "숫자 일치 개수는 1보다 커야합니다" }
        require(matchCount <= Lotto.NUMBER_COUNT) { "숫자 일치 개수는 최대 ${Lotto.NUMBER_COUNT}개까지 가능합니다" }
    }
}
