package lotto

object InputView {
    private val WINNING_NUMBER_REGEX = Regex("(([0-9])+,){5}([0-9])")
    private const val DELIMITER = ","
    private const val UNIT = 1000

    tailrec fun inputAmountOfMoney(): Int {
        println("구입금액을 입력해 주세요.")
        val amountOfMoney = readLine()?.toIntOrNull()
        return if (amountOfMoney !== null && amountOfMoney % UNIT == 0 && amountOfMoney != 0) {
            amountOfMoney
        } else {
            println("금액은 천원 단위만 입력할 수 있습니다. 다시 입력해주세요.")
            inputAmountOfMoney()
        }
    }

    tailrec fun inputWinningNumbers(): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = inputNumbers()
        val winningNumbers = numbers?.replace(" ", "")
            ?.split(DELIMITER)
            ?.map { it.toInt() }

        return if (winningNumbers != null && isNotDuplicated(winningNumbers)) {
            winningNumbers
        } else {
            println("당첨번호는 1,2,3,4,5,6 형태입니다. 다시 입력해주세요.")
            inputWinningNumbers()
        }
    }

    tailrec fun inputBonusBall(): Int {
        println("보너스 볼을 입력해주세요.")
        val bonusBall = readLine()?.toIntOrNull()
        return if (bonusBall != null && bonusBall >= 1 && bonusBall <= 45) {
            bonusBall
        } else {
            println("보너스 볼은 한자리 숫자이거나 1 ~ 45 사이의 숫자만 가능합니다. 다시 입력해주세요.")
            inputBonusBall()
        }
    }

    private fun inputNumbers(): String? {
        var numbers = readLine()
        if (numbers != null && !WINNING_NUMBER_REGEX.matches(numbers)) {
            numbers = null
        }
        return numbers
    }

    private fun isNotDuplicated(numbers: List<Int>): Boolean {
        return numbers.distinct() == numbers
    }
}
