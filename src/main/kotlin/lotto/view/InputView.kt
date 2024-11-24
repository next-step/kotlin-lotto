package lotto.view

import lotto.domain.BonusNumber
import lotto.domain.Lotto
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

    fun readWinningLotto(): WinningLotto {
        println("지난 주 당첨 번호를 입력해 주세요. (쉼표로 구분)")
        val winningLotto = readWinningNumbers()
        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = readBonusNumber(winningLotto)
        return WinningLotto(winningLotto, bonusNumber)
    }

    fun readWinningNumbers(): Lotto {
        val input = readlnOrNull() ?: exitProgram()
        return try {
            val numbers =
                input.split(",").map {
                    it.trim().toInt()
                }
            Lotto(numbers.toSet())
        } catch (e: NumberFormatException) {
            println("유효하지 않은 숫자입니다. 숫자를 입력해 주세요.")
            return readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readWinningNumbers()
        }
    }

    fun readBonusNumber(winningLotto: Lotto): BonusNumber {
        val input = readlnOrNull() ?: exitProgram()
        return try {
            BonusNumber.create(input.toInt(), winningLotto)
        } catch (e: NumberFormatException) {
            println("유효하지 않은 숫자입니다. 숫자를 입력해 주세요.")
            return readBonusNumber(winningLotto)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            return readBonusNumber(winningLotto)
        }
    }

    private fun exitProgram(): Nothing {
        println("프로그램을 종료합니다.")
        kotlin.system.exitProcess(0)
    }
}
