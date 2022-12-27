package lotto.domain

data class WinningBalls(
    val balls: Set<LottoNumber>,
) : Set<LottoNumber> by balls {
    init {
        require(balls.size == 6) { "당첨 번호는 중복이 없어야 합니다." }
    }
}
