package lotto.view.output

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoCount
import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoes

class SixFortyFiveLottoOutputView(
    lottoes: SixFortyFiveLottoes,
    autoLottoCount: SixFortyFiveLottoCount,
    manualLottoCount: SixFortyFiveLottoCount,
) {
    init {
        println("수동으로 ${manualLottoCount.value}장, 자동으로 ${autoLottoCount.value}개를 구매했습니다.")
        println(lottoes.getList().map { lotto -> lotto.numbers.toString() + "\n" }.reduce { acc, s -> acc + s })
    }
}
