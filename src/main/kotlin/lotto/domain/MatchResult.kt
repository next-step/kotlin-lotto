package lotto.domain

class MatchResult(count: Int, matchBonus: Boolean) {

    val lottiPrize = LottoPrize.from(count, matchBonus)

    init {
        require(0 <= count) { "일치하는 숫자의 개수는 0보다 작을 수 없습니다." }
    }
}
