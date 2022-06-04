package com.nextstep.jngcii.lotto

import com.nextstep.jngcii.lotto.model.BonusNumber
import com.nextstep.jngcii.lotto.model.Lotto
import com.nextstep.jngcii.lotto.model.LottoMachine
import com.nextstep.jngcii.lotto.model.LottoNumber
import com.nextstep.jngcii.lotto.model.Ranks
import com.nextstep.jngcii.lotto.view.InputView
import com.nextstep.jngcii.lotto.view.ResultView

fun main() {
    val count = InputView.getCount()

    val lottos = LottoMachine.get(count)
    ResultView.printList(lottos)

    val lastWeekNumbers = InputView.getNumbers()
    val lastWeekLotto = Lotto(lastWeekNumbers.map { LottoNumber(it) })
    val number = InputView.getNumber()
    val bonus = BonusNumber(number, lastWeekLotto)

    val ranks = Ranks(lottos, lastWeekLotto, bonus)
    ResultView.printResult(count, ranks)
}
