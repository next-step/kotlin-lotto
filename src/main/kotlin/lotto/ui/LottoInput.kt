package lotto.ui

import lotto.domain.WinningInfo

private const val REQUEST_NUMBER_MESSAGE = "숫자를 입력해 주세요."

object LottoInput {
    tailrec fun requestMoney(): Int {
        val money = promptAndReadNumber("구입금액을 입력해 주세요.")

        return if (money == null) {
            println(REQUEST_NUMBER_MESSAGE)
            requestMoney()
        } else {
            money
        }
    }

    tailrec fun requestWinningNumbers(): List<String> {
        val winningNumbers = promptAndRead("지난 주 당첨 번호를 입력해 주세요.")

        return if (winningNumbers == null) {
            println("유효한 당첨 번호를 입력해주세요.")
            requestWinningNumbers()
        } else {
            winningNumbers.split(WinningInfo.DELIMITER).map(String::trim)
        }
    }

    tailrec fun requestBonusNumber(): Int {
        val bonusNumber = promptAndReadNumber("보너스 볼을 입력해 주세요.")

        return if (bonusNumber == null) {
            println(REQUEST_NUMBER_MESSAGE)
            requestBonusNumber()
        } else {
            bonusNumber
        }
    }

    private fun promptAndReadNumber(prompt: String): Int? {
        return promptAndRead(prompt)?.toIntOrNull()
    }

    private fun promptAndRead(prompt: String): String? {
        println(prompt)
        return readlnOrNull()?.trim()
    }
}
