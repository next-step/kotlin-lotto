package lotto.view.output.sixFortyFiveNumberLotto

import lotto.sixFortyFiveNumberLotto.SixFortyFiveLotto
import lotto.view.output.OutputView

class SixFortyFiveLottoOutputView(lottoList: List<SixFortyFiveLotto>) :
    OutputView(
        lottoList.map { lotto -> lotto.numbers.value.toString() + "\n" }
            .reduce { acc, s -> acc + s },
    )
