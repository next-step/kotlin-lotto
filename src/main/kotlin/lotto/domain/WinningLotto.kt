package lotto.domain

data class WinningLotto(
    private val lotto: Lotto,
    private val bonusNumber: LottoNumber
) {
    init {
        require(!lotto.numbers.contains(bonusNumber)) { "보너스 번호는 당첨 번호에 포함될 수 없습니다. [${lotto.numbers}, $bonusNumber]" }
    }

    fun match(lotto: Lotto): Rank? {
        val matchCount = lotto.match(this.lotto)
        val bonusMatch = lotto.contains(bonusNumber)
        return Rank.from(matchCount, bonusMatch)
    }

    companion object {
        fun from(winningNumbers: List<Int>, bonusNumber: Int): WinningLotto {
            return WinningLotto(
                Lotto.of(winningNumbers),
                LottoNumber(bonusNumber)
            )
        }
    }
}
