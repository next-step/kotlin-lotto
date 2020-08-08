package lotto.view

import lotto.model.Lotto
import lotto.model.LottoNo
import lotto.model.LottoPaper
import lotto.model.MINIMUM_LOTTO_COUNT
import lotto.model.Money

const val WINNER_NUMBER_DELIMITER = ","

object InputView {
    fun getAmountOfMoney(): Money {
        println("구입금액을 입력해 주세요.")

        val money = Money(readLine()!!.toInt())

        require(money.canBuyLotto(MINIMUM_LOTTO_COUNT)) { "돈이 부족합니다." }

        return money
    }

    fun getManualLottoCount(money: Money): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")

        val manualLottoCount = readLine()!!.toInt()

        require(money.canBuyLotto(manualLottoCount)) { "입력한 수동로또를 구매하기 위한 돈이 부족합니다." }

        return manualLottoCount
    }

    fun getManualLotto(manualLottoCount: Int): LottoPaper {
        println("수동으로 구매할 번호를 입력해 주세요.")

        val manualLottos = mutableListOf<Lotto>()

        do {
            val lotto = Lotto.make(readLine().toString())
            manualLottos.add(lotto)
        } while (manualLottos.size < manualLottoCount)

        return LottoPaper(manualLottos)
    }

    fun getWinnerLotto(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요.")

        return Lotto.make(readLine().toString())
    }

    fun getBonusNumber(): LottoNo {
        println("보너스 볼을 입력해 주세요.")

        return LottoNo.from(readLine()!!.toInt())
    }
}
