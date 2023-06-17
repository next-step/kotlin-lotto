package lotto

import lotto.domain.LotteryTicket
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.WinningLottoNumber

object LottoTestHelper {

    fun makeLotteryTicket(numbers: List<Int>, isAuto: Boolean = false): LotteryTicket =
        LotteryTicket(lottoNumbers = LottoNumbers(numbers.map { LottoNumber(it) }), isAuto = isAuto)

    fun makeWinningLottoNumbers(numbers: List<Int>, bonusNumber: Int): WinningLottoNumber {
        return WinningLottoNumber(
            winningNumbers = LottoNumbers(numbers.map { LottoNumber(it) }),
            bonusLottoNumber = LottoNumber(bonusNumber),
        )
    }

    fun makeLottoNumbers(numbers: List<Int>): LottoNumbers = LottoNumbers(
        numbers.map { LottoNumber(it) },
    )
}
