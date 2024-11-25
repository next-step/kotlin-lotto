package lotto.view

import lotto.domain.Amount
import lotto.domain.BonusNumber
import lotto.domain.Lotto
import lotto.domain.WinningLotto

class InputView {
    fun readPurchaseAmount(): Amount {
        return readAndParse(
            prompt = "구입 금액을 입력해 주세요.",
            parser = { Amount(it.toInt()) },
        )
    }

    fun readManualLottos(
        manualCount: Int,
        manualLottos: MutableList<Lotto> = mutableListOf(),
    ): List<Lotto> {
        if (manualCount == 0) {
            return emptyList()
        }
        println("수동으로 구매할 번호를 입력해 주세요.")

        while (manualLottos.size < manualCount) {
            val input = readlnOrNull() ?: exitProgram()
            val remainCount = manualCount - manualLottos.size

            try {
                manualLottos.add(lottoParse(input))
            } catch (e: NumberFormatException) {
                println("유효하지 않은 숫자입니다. 다시 입력해 주세요. (${remainCount}개 남음)")
                readManualLottos(remainCount, manualLottos)
            } catch (e: IllegalArgumentException) {
                println("${e.message}. 다시 입력해 주세요. (${remainCount}개 남음)")
                readManualLottos(remainCount, manualLottos)
            }
        }

        return manualLottos
    }

    fun readManualCount(purchasedCount: Int): Int {
        return readAndParse(
            prompt = "수동으로 구매할 로또 수를 입력해 주세요.",
            parser = { it.toInt() },
            validator = { it <= purchasedCount },
            errorMessage = "수동으로 구매할 로또 수는 총 구매한 로또 수보다 작아야 합니다.",
        )
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
            lottoParse(input)
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

    private fun lottoParse(input: String): Lotto {
        val numbers =
            input.split(",")
                .map { it.trim().toInt() }
                .toSet()

        return Lotto(numbers)
    }

    private inline fun <T> readAndParse(
        prompt: String,
        parser: (String) -> T,
        validator: (T) -> Boolean = { true },
        errorMessage: String = "유효하지 않은 입력입니다. 다시 시도해 주세요.",
    ): T {
        while (true) {
            println(prompt)
            val input = readlnOrNull() ?: exitProgram()
            try {
                val parsedValue = parser(input)
                require(validator(parsedValue)) { errorMessage }
                return parsedValue
            } catch (e: Exception) {
                println(e.message ?: errorMessage)
            }
        }
    }
}
