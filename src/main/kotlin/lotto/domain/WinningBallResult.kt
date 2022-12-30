package lotto.domain

data class WinningBallResult(
    val winningBalls: WinningBalls,
    val bonusBall: LottoNumber,
) {
    init {
        require(!winningBalls.contains(bonusBall)) { "보너스 볼은 당첨 번호와 중복될 수 없습니다." }
    }
}
