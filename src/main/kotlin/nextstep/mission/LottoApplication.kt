package nextstep.mission

import nextstep.mission.lotto.Lotto
import nextstep.mission.lotto.LottoMachine
import nextstep.mission.lotto.io.ConsoleInput
import nextstep.mission.lotto.io.ConsoleOutput
import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningResult

fun main() {
    val inputPrice: Int = ConsoleInput.inputPrice()
    val lotto: Lotto = LottoMachine.create(inputPrice)
    ConsoleOutput.printLotto(lotto)
    val winningNumbers: LottoNumbers = ConsoleInput.inputWinningNumbers2()
    val result: WinningResult = lotto.matchWinningNumbers(winningNumbers)
}
