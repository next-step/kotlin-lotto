package lotto.view

import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import math.PositiveNumber

class RealLottoInputView : LottoInputView {

    override fun readLottoPurchaseAmount(): PositiveNumber {
        println("구입금액을 입력해 주세요.")
        return PositiveNumber(readln().toInt())
    }

    override fun readLastWeekWinLottoNumbers(): LottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return LottoNumbers(
            value = readln().split(", ")
                .map { maybeNumber -> maybeNumber.toInt() }
                .map { maybeLottoNumber -> LottoNumber(maybeLottoNumber) }
        )
    }
}
