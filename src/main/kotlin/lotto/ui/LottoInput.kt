package lotto.ui

import lotto.domain.WinningNumbers

object LottoInput {
    tailrec fun requestMoney(): Int {
        val money = promptAndReadNumber("구입금액을 입력해 주세요.")

        return if (money == null) {
            println("숫자를 입력해 주세요.")
            requestMoney()
        } else {
            money
        }
    }

    fun requestWinningNumbers(): List<String> {
        val winningNumbers = promptAndRead("지난 주 당첨 번호를 입력해 주세요.")

        return if (winningNumbers == null) {
            println("유효한 당첨 번호를 입력해주세요.")
            requestWinningNumbers()
        } else {
            winningNumbers.split(WinningNumbers.DELIMITER).map(String::trim)
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
