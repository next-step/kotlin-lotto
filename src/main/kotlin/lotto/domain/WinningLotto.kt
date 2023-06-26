package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: LottoNumber
) {
    init {
        if (lotto.containNumber(bonusNumber)) {
            throw IllegalArgumentException("보너스 넘버는 로또당첨번호에 포함되면 안됩니다.")
        }
    }
}
