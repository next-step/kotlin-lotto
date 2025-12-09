package lotto.domain

class BonusBall(
    winLotto: Lotto,
    val bonusNumber: LottoNumber,
) {
    init {
        require(bonusNumber !in winLotto.numbers) {
            "보너스 번호는 당첨 번호와 겹칠 수 없습니다."
        }
    }

    fun matches(lotto: Lotto): Boolean {
        return bonusNumber in lotto.numbers
    }
}
