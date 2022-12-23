package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNumber
import lotto.service.LottoGenerator
import java.math.BigDecimal

object InputView {
    fun readMoney(): BigDecimal {
        println("구입금액을 입력해 주세요.")
        return readln().toBigDecimal()
    }

    fun readWinningLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해주세요.")
        return LottoGenerator.fromString(readln())
    }

    fun readBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.of(readln())
    }
}
