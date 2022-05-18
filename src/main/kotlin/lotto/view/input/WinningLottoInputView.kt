package lotto.view.input

import lotto.model.data.Lotto
import lotto.model.data.Policy
import lotto.view.input.parser.LottoInputParser

class WinningLottoInputView(private val policy: Policy) : InputView<Lotto> {

    override fun getInput(): Lotto {
        return ConsoleReader.read("지난 주 당첨 번호를 입력해 주세요.", LottoInputParser(policy))
    }
}
