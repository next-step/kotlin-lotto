package lotto.provider.winningnumber

import lotto.domain.LottoNumber
import lotto.domain.WinningNumber

class UserWinningNumberProvider : WinningNumberProvider {
    override fun provide(): WinningNumber {
        return println("당첨번호는 무엇인가요?").run {
            WinningNumber(readln().trim().split(",").map { it.toInt() }.map { LottoNumber(it) })
        }
    }
}
