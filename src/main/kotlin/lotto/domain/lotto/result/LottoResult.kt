package lotto.domain.lotto.result

import lotto.domain.lotto.Lotto
import lotto.domain.lotto.LottoAnswer
import lotto.domain.lotto.benefit.LottoBenefit

class LottoResult(lotto: Lotto, lottoAnswer: LottoAnswer) {

    val lottoBenefit: LottoBenefit = lotto.benefit(lottoAnswer)

    val lottoResultCountMap: LottoResultCountMap = lottoAnswer.calculate(lotto)
}
