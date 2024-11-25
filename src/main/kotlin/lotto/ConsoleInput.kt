package lotto

class ConsoleInput {
    companion object {
        fun inputBalance(): Money {
            println("구입금액을 입력해 주세요.")
            return Money(readln().toInt())
        }

        fun inputDefaultWinningTicket(): LottoTicket {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return LottoTicket(readln().split(", ").map(String::toInt).map(::LottoNumber))
        }

        fun inputBonusNumber(): LottoNumber {
            println("보너스 볼을 입력해 주세요.")
            return LottoNumber(readln().toInt())
        }
    }
}
