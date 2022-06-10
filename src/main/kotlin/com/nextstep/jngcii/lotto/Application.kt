package com.nextstep.jngcii.lotto

import com.nextstep.jngcii.lotto.model.BonusNumber
import com.nextstep.jngcii.lotto.model.Lotto
import com.nextstep.jngcii.lotto.model.LottoMachine
import com.nextstep.jngcii.lotto.model.LottoNumber
import com.nextstep.jngcii.lotto.model.Ranks
import com.nextstep.jngcii.lotto.view.InputView
import com.nextstep.jngcii.lotto.view.ResultView

fun main() {
    val total = InputView.getCount()

    val passiveCount = InputView.getPassiveCount(total)
    val autoCount = total - passiveCount

    val lottos = LottoMachine.get(autoCount)
    ResultView.printList(lottos)

    val lastWeekNumbers = InputView.getNumbers()
    val lastWeekLotto = Lotto(lastWeekNumbers.map { LottoNumber(it) })
    val number = InputView.getNumber()
    val bonus = BonusNumber(number, lastWeekLotto)

    val ranks = Ranks(lottos, lastWeekLotto, bonus)
    ResultView.printResult(total, ranks)
}
