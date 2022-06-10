package com.nextstep.jngcii.lotto

import com.nextstep.jngcii.lotto.model.BonusNumber
import com.nextstep.jngcii.lotto.model.LottoMachine
import com.nextstep.jngcii.lotto.model.Ranks
import com.nextstep.jngcii.lotto.view.InputView
import com.nextstep.jngcii.lotto.view.ResultView

fun main() {
    val total = InputView.getCount()

    val passiveCount = InputView.getPassiveCount(total)
    val autoCount = total - passiveCount

    val passiveLottos = InputView.getPassiveLottos(passiveCount)
    val autoLottos = LottoMachine.get(autoCount)
    ResultView.printList(passiveLottos, autoLottos)

    val lottos = passiveLottos + autoLottos
    val lastWeekLotto = InputView.getLastWeekLotto()
    val number = InputView.getNumber()
    val bonus = BonusNumber(number, lastWeekLotto)

    val ranks = Ranks(lottos, lastWeekLotto, bonus)
    ResultView.printResult(ranks)
}
