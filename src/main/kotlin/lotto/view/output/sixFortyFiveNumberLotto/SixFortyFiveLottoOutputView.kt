package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLottoes

class SixFortyFiveLottoOutputView(
    lottoes: SixFortyFiveLottoes,
    autoLottoSize: Int? = null,
    manualLottoSize: Int? = null,
) {
    init {
        if (manualLottoSize != null && autoLottoSize != null) println("수동으로 ${manualLottoSize}장, 자동으로 ${autoLottoSize}개를 구매했습니다.")
        println(lottoes.getList().map { lotto -> lotto.numbers.toString() + "\n" }.reduce { acc, s -> acc + s })
    }
}
