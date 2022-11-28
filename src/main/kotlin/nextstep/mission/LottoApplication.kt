package nextstep.mission

import nextstep.mission.lotto.Lotto
import nextstep.mission.lotto.LottoShop
import nextstep.mission.lotto.io.ConsoleInput
import nextstep.mission.lotto.io.ConsoleOutput
import nextstep.mission.lotto.io.dto.LottoDto
import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningResult

fun main() {
    val inputPrice: Int = ConsoleInput.inputPrice()
    val lotto: Lotto = LottoShop.purchaseBy(inputPrice)
    ConsoleOutput.printLotto(LottoDto.from(lotto))
    val winningNumbers: LottoNumbers = ConsoleInput.inputWinningNumbers()
    val result: WinningResult = lotto.matchWinningNumbers(winningNumbers)
    ConsoleOutput.printWinningResult(result, result.rateOfReturn(inputPrice))
}
