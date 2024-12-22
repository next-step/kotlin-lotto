package lotto

import lotto.model.price.Lotto2024Price
import lotto.model.process.LottoMachineProcess
import lotto.model.rank.LottoWinningRank
import lotto.view.keyboard.MachineKeyboard
import lotto.view.monitor.LottoMonitor

fun main() {
    val price = Lotto2024Price()
    val lottoRank = LottoWinningRank()
    val process = LottoMachineProcess(price, lottoRank)
    val keyboard = MachineKeyboard()
    val monitor = LottoMonitor()
    val machine = LottoMachine(process, keyboard, monitor)
    machine.issuanceLottoNumber()
}
