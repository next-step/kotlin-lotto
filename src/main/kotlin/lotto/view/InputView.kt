package lotto.view

import lotto.Lotto
import lotto.LottoNumber

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요. 한장당 가격은 1000원입니다. ")
        return readln().toInt()
    }

    fun readWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요. 6자리이며 쉼표 기준으로 구분합니다.")
        return try {
            val numbers = readln().split(",")
                .map { it.trim().toInt() }
                .map { LottoNumber(it) } // Int를 LottoNumber로 변환
            Lotto(numbers)
        } catch (e: Exception) {
            throw IllegalArgumentException("올바른 당첨 번호를 입력해주세요.")
        }
    }
}
