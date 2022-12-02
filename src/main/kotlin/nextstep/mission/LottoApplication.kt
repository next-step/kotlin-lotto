package nextstep.mission

import nextstep.mission.lotto.LOTTO_PRICE
import nextstep.mission.lotto.Lotto
import nextstep.mission.lotto.LottoShop
import nextstep.mission.lotto.dto.LottoDto
import nextstep.mission.lotto.io.ConsoleInput
import nextstep.mission.lotto.io.ConsoleOutput
import nextstep.mission.lotto.vo.LottoNumber
import nextstep.mission.lotto.vo.LottoNumbers
import nextstep.mission.lotto.vo.WinningResult

fun main() {
    val purchasePrice: Int = ConsoleInput.inputPrice()
    val manualCount: Int = ConsoleInput.inputManualLottoCount()
    val manualLotto: Lotto = ConsoleInput.inputManualLotto(manualCount)

    val autoLotto: Lotto = LottoShop.purchaseAutoLottoBy(purchasePrice - LOTTO_PRICE * manualCount)

    ConsoleOutput.printLotto(LottoDto.from(manualLotto), LottoDto.from(autoLotto))

    val winningNumbers: LottoNumbers = ConsoleInput.inputWinningNumbers()
    val bonusNumber: LottoNumber = ConsoleInput.inputBonusNumber()

    val result: WinningResult = (manualLotto + autoLotto).matchWinningNumbers(winningNumbers, bonusNumber)

    ConsoleOutput.printWinningResult(result, result.rateOfReturn(purchasePrice))
}
