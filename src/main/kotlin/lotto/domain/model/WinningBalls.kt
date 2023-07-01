package lotto.domain.model

data class WinningBalls(val balls: List<LottoNumber>) {
    init {
        require(balls.size == Lotto.NUMBER_COUNT) { "${Lotto.NUMBER_COUNT}개의 당첨 번호가 필요합니다" }
    }
}
