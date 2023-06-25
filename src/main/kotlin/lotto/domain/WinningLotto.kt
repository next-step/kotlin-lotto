package lotto.domain

class WinningLotto(
    val lotto: Lotto,
    val bonusNumber: Int
) {
    init {
        if (lotto.numbers.map { it.number }.contains(bonusNumber)) {
            throw IllegalArgumentException("보너스 넘버는 로또당첨번호에 포함되면 안됩니다.")
        }
    }
}
