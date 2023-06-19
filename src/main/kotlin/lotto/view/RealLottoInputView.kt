package lotto.view

import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers
import math.PositiveNumber

class RealLottoInputView : LottoInputView {

    override fun readLottoPurchaseAmount(): PositiveNumber {
        println("구입금액을 입력해 주세요.")
        return PositiveNumber(readln().toInt())
    }

    override fun readLastWeekWinLottoNumbers(): WinLottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lottoNumbers = LottoNumbers(
            readln().split(", ")
                .map { maybeNumber -> maybeNumber.toInt() }
                .map { maybeLottoNumber -> LottoNumber(maybeLottoNumber) }
        )

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(readln().toInt())

        return WinLottoNumbers(
            lottoNumbers = lottoNumbers,
            bonusNumber = bonusNumber,
        )
    }
}
