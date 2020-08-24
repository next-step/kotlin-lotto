package lotto

object InputView {
    private val WINNING_NUMBER_REGEX = Regex("(([0-9])+,){5}([0-9])")
    private const val DELIMITER = ","

    tailrec fun inputManualLottoCount(amountOfLottos: Int, validateAmountOfLotto: (Int, Int) -> Boolean): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val manualNumberCount = readLine()?.toIntOrNull()
        return if (manualNumberCount != null && validateAmountOfLotto(manualNumberCount, amountOfLottos)) {
            manualNumberCount
        } else {
            println("숫자만 입력가능하고, 구입한 로또 장수보다 같거나 적어야 합니다.")
            inputManualLottoCount(amountOfLottos, validateAmountOfLotto)
        }
    }

    fun inputManualNumbers(
        manualNumberCount: Int,
        isDuplicate: (List<Int>) -> Boolean,
        isNumbersInRange: (List<Int>) -> Boolean
    ): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (0 until manualNumberCount).map {
            Lotto(inputManualNumber(isDuplicate, isNumbersInRange))
        }
    }

    private fun inputManualNumber(
        isDuplicate: (List<Int>) -> Boolean,
        isNumbersInRange: (List<Int>) -> Boolean
    ): List<Int> {
        val numbers = inputNumbers()
        val manualNumbers = numbers?.replace(" ", "")
            ?.split(DELIMITER)
            ?.map { it.toInt() }
            ?: emptyList()
        return if (isDuplicate(manualNumbers) && isNumbersInRange(manualNumbers)) {
            manualNumbers
        } else {
            println("로또 번호 1,2,3,4,5,6 형태이고, 1~45사이의 숫자입니다. 다시 입력해주세요.")
            inputManualNumber(isDuplicate, isNumbersInRange)
        }
    }

    tailrec fun inputAmountOfMoney(validateMoneyUnit: (Int) -> Boolean): Int {
        println("구입금액을 입력해 주세요.")
        val amountOfMoney = readLine()?.toIntOrNull()
        return if (amountOfMoney != null && validateMoneyUnit(amountOfMoney)) {
            amountOfMoney
        } else {
            println("금액은 천원 단위만 입력할 수 있습니다. 다시 입력해주세요.")
            inputAmountOfMoney(validateMoneyUnit)
        }
    }

    tailrec fun inputWinningNumbers(
        isDuplicate: (List<Int>) -> Boolean,
        isNumbersInRange: (List<Int>) -> Boolean
    ): List<Int> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val numbers = inputNumbers()
        val winningNumbers = numbers?.replace(" ", "")
            ?.split(DELIMITER)
            ?.map { it.toInt() }
            ?: emptyList()

        return if (isDuplicate(winningNumbers) && isNumbersInRange(winningNumbers)) {
            winningNumbers
        } else {
            println("번호는 1,2,3,4,5,6 형태이고, 1~45 사이의 숫자입니다. 다시 입력해주세요.")
            inputWinningNumbers(isDuplicate, isNumbersInRange)
        }
    }

    tailrec fun inputBonusBall(isInRange: (Int) -> Boolean): Int {
        println("보너스 볼을 입력해주세요.")
        val bonusBall = readLine()?.toIntOrNull()
        return if (bonusBall != null && isInRange(bonusBall)) {
            bonusBall
        } else {
            println("보너스 볼은 한자리 숫자이거나 1 ~ 45 사이의 숫자만 가능합니다. 다시 입력해주세요.")
            inputBonusBall(isInRange)
        }
    }

    private fun inputNumbers(): String? {
        var numbers = readLine()
        if (numbers != null && !WINNING_NUMBER_REGEX.matches(numbers)) {
            numbers = null
        }
        return numbers
    }
}
