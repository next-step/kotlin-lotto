package lotto.model

data class WinningLotto(
    val lotto: Lotto,
    val bonus: LottoNumber
) {

    init {
        require(!lotto.isBonusMatch(bonus)) {
            "보너스 숫자는 중복될 수 없습니다."
        }
    }
}
