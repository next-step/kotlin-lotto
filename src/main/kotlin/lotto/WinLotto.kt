package lotto

class WinLotto {
    val winLotto: Lotto
    val bonusBall: LottoNumber

    constructor(winLotto: String?, bonusBall: String?) {
        require(!winLotto.isNullOrBlank()) { "당첨 번호를 입력하세요" }
        require(!bonusBall.isNullOrBlank()) { "보너스볼을 입력하세요" }

        this.winLotto = Lotto.ofManual(winLotto)
        this.bonusBall = validateBonusBall(bonusBall)
    }

    fun matchCount(lotto: Lotto): Int {
        return winLotto.numbers.intersect(lotto.numbers.toSet()).size
    }

    fun matchBonusBall(lotto: Lotto): Boolean {
        return lotto.numbers.contains(bonusBall)
    }

    private fun validateBonusBall(bonusBall: String): LottoNumber {
        val bonusBallNumber = LottoNumber(bonusBall.toInt())
        require(bonusBallNumber !in winLotto.numbers) { "보너스볼은 당첨 번호와 겹치지 않게 선택해주세요" }
        return bonusBallNumber
    }
}
