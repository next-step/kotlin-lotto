package com.nextstep.jngcii.lotto

import com.nextstep.jngcii.lotto.model.Lotto
import com.nextstep.jngcii.lotto.model.LottoMachine
import com.nextstep.jngcii.lotto.model.Record
import com.nextstep.jngcii.lotto.view.InputView
import com.nextstep.jngcii.lotto.view.ResultView

fun main() {
    ResultView.printBeforeGetCount()
    val count = InputView.getCount(readLine())

    val lottos = LottoMachine.get(count)
    ResultView.printList(lottos)

    val record = Record(lottos)

    ResultView.printBeforeGetNumbers()
    val lastWeekNumbers = InputView.getNumbers(readLine())
    val lastWeekLotto = Lotto(lastWeekNumbers)

    val ranks = record.getResult(lastWeekLotto)
    ResultView.printResult(count, ranks)
}
