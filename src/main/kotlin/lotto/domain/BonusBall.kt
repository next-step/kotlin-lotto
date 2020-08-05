package lotto.domain

class BonusBall(correctLotto: Lotto, number: Number) {
    val number = checkNumber(correctLotto, number)

    private fun checkNumber(correctLotto: Lotto, number: Number): Number {
        if (correctLotto.numbers.contains(number)) {
            throw IllegalArgumentException("보너스 번호는 당첨번호와 같으면 안됩니다.")
        } else {
            return number
        }
    }
}
