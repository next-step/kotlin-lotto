package lotto.domain

class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber
) {
    init {
        require(!lotto.numbers.contains(bonusNumber)) { "보너스 번호는 당첨 번호에 포함될 수 없습니다. [${lotto.numbers}, $bonusNumber]" }
    }

    companion object {
        fun from(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
            return WinningLotto(
                Lotto.from(winningNumbers),
                LottoNumber(bonusNumber)
            )
        }
    }
}
