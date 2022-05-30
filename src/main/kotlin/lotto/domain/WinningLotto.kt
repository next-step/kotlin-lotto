package lotto.domain

data class WinningLotto(
    val lotto: Lotto,
    val bonusBall: LottoNumber
) {
    init {
        require(bonusBall !in lotto) { "보너스 볼은 당첨 로또의 번호와 중복될 수 없습니다" }
    }
}
