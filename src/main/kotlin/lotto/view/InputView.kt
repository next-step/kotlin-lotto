package lotto.view

import lotto.domain.WinningLotto

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입 금액을 입력해 주세요.")
        val input = readlnOrNull() ?: exitProgram()
        return try {
            input.toInt()
        } catch (e: NumberFormatException) {
            println("유효하지 않은 금액입니다. 숫자를 입력해 주세요.")
            return readPurchaseAmount()
        }
    }

    fun readWinningNumbers(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)")
        val input = readlnOrNull() ?: exitProgram()

        return try {
            val numbers =
                input.split(",").map {
                    it.trim().toInt()
                }
            WinningLotto(numbers.toSet())
        } catch (e: NumberFormatException) {
            println("유효하지 않은 숫자입니다. 숫자를 입력해 주세요.")
            return readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readWinningNumbers()
        }
    }

    private fun exitProgram(): Nothing {
        println("프로그램을 종료합니다.")
        kotlin.system.exitProcess(0)
    }
}
