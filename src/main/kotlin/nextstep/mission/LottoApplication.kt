package nextstep.mission

import nextstep.mission.lotto.Lottos
import nextstep.mission.lotto.WinningResult
import nextstep.mission.lotto.io.ConsoleInput
import nextstep.mission.lotto.io.ConsoleOutput

fun main() {
    val inputPrice: Int = ConsoleInput.inputPrice()
    val lottos = Lottos(inputPrice)
    ConsoleOutput.printLottos(lottos.lottos)
    val winningNumbers: List<Int> = ConsoleInput.inputWinningNumbers()
    val winningResult: WinningResult = lottos.checkWinningNumbers(winningNumbers)
    ConsoleOutput.printWinningResult(winningResult)
}
