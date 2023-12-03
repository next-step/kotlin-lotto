package lotto.ui

import lotto.vo.ManualLotto

object InputView {
    fun promptForPrice(): Long {
        println("구입금액을 입력해 주세요.")
        return readln().toLongOrNull() ?: throw IllegalArgumentException("가격 입력이 올바르지 않습니다.")
    }

    fun promptForLastWeekWinningNumbers(): String {
        println("지난 주 당첨 번호를 입력해 주세요.")
        return readln()
    }

    fun promptForBonusNumbers(): String {
        println("보너스 볼을 입력해 주세요.")
        return readln()
    }

    fun promptForManualLottoCount(): Long {
        println("수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toLongOrNull() ?: throw IllegalArgumentException("로또 수 입력이 올바르지 않습니다.")
    }

    fun promptForManualLotto(count: Long): ManualLotto {
        println("수동으로 구매할 번호를 입력해 주세요.")
        val manualLottos = ManualLotto()
        for (i in 1..count) {
            val inputString = readln()
            manualLottos.initLottoNumbers(inputString)
        }
        return manualLottos
    }
}
