package lotto.view

import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers
import lotto.domain.shop.LottoPurchasePaper
import lotto.domain.shop.SelfSettingLottoGame
import math.PositiveNumber

class RealLottoInputView : LottoInputView {

    override fun readLottoPurchaseInfo(): LottoPurchasePaper {
        println("구입금액을 입력해 주세요.")
        val lottoPurchaseAmount = PositiveNumber(readln().toInt())
        println()
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        val selfSettingCount = readln().toInt()
        val selfSettingLottoGames = if (selfSettingCount > 0) {
            println()
            println("수동으로 구매할 번호를 입력해 주세요.")
            List(selfSettingCount) {
                SelfSettingLottoGame(readln().toLottoNumbers())
            }
        } else {
            emptyList()
        }
        println()
        return LottoPurchasePaper(
            lottoPurchaseAmount = lottoPurchaseAmount,
            selfSettingLottoGames = selfSettingLottoGames,
        )
    }

    override fun readLastWeekWinLottoNumbers(): WinLottoNumbers {
        println("지난 주 당첨 번호를 입력해 주세요.")
        val lottoNumbers = readln().toLottoNumbers()

        println("보너스 볼을 입력해 주세요.")
        val bonusNumber = LottoNumber(readln().toInt())

        return WinLottoNumbers(
            lottoNumbers = lottoNumbers,
            bonusNumber = bonusNumber,
        )
    }

    private fun String.toLottoNumbers(): LottoNumbers {
        val lottoNumbers = split(", ")
            .map { maybeNumber -> maybeNumber.toInt() }
            .map { maybeLottoNumber -> LottoNumber(maybeLottoNumber) }
        return LottoNumbers(lottoNumbers)
    }
}
