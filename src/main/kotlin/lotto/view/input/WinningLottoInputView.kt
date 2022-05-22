package lotto.view.input

import lotto.model.data.Policy
import lotto.model.data.WinningLotto
import lotto.model.data.WinningLotto.Companion.toWinningLotto
import lotto.view.input.parser.BonusNumberInputParser
import lotto.view.input.parser.LottoInputParser

class WinningLottoInputView(private val policy: Policy) : InputView<WinningLotto> {

    override fun getInput(): WinningLotto {
        val lotto = ConsoleReader.read("지난 주 당첨 번호를 입력해 주세요.", LottoInputParser(policy))
        val bonusNumber = ConsoleReader.read("보너스 볼을 입력해 주세요.", BonusNumberInputParser(policy, lotto))
        return lotto.toWinningLotto(policy, bonusNumber)
    }
}
