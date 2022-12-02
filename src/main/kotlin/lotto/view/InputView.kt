package lotto.view

private const val DELIMITERS = ", "

object InputView {

    fun inputMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun inputManualLottoNumbers(count: Int): List<List<Int>> {
        println("수동으로 구매할 번호를 입력해 주세요.")

        return (0 until count).map {
            readln().split(DELIMITERS).map { it.toInt() }
        }
    }

    fun inputWinningNumber(): List<Int> {
        println()
        println("지난 주 당첨 번호를 입력해 주세요.")

        val tokens = readln().split(DELIMITERS)

        return tokens.map { it.toInt() }
    }

    fun inputBonusNumber(): Int {
        println("보너스 볼을 입력해 주세요.")

        return readln().toInt()
    }
}
