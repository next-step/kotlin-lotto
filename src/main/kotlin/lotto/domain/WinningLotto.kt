package lotto.domain

class WinningLotto(correctLotto: Lotto, number: Number) {
    val lotto = correctLotto
    private val bonusBall = checkNumber(correctLotto, number)

    private fun checkNumber(correctLotto: Lotto, number: Number): Number {
        if (correctLotto.isCorrect(number)) {
            throw IllegalArgumentException("보너스 번호는 당첨번호와 같으면 안됩니다.")
        }
        return number
    }

    fun match(userLotto: Lotto): PrizeMoney {
        val countMatch = userLotto.getCountMatch(lotto.numbers)
        val isBonus = userLotto.isCorrect(bonusBall)
        return PrizeMoney.getRank(countMatch, isBonus)
    }
}
