package lotto.view

import lotto.domain.LottoNumber

object InputView {
    private const val DELIMITER = ", "
    fun enterMoney(): Int {
        println("구입금액을 입력해 주세요.")
        return readln().toInt()
    }

    fun enterWinningLotto(): List<LottoNumber> {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln().split(DELIMITER).map { LottoNumber.of(it.trim().toInt()) }
    }

    fun enterBonusNumber(): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        return LottoNumber.of(readln().toInt())
    }

    fun enterManualLottoCount(): Int {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun enterManualLotto(manualLottoCount: Int): List<List<LottoNumber>> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return List(manualLottoCount) { readln().split(DELIMITER).map { LottoNumber.of(it.trim().toInt()) } }
    }
}
