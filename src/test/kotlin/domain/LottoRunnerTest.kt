package domain

import LottoRunner
import io.kotest.core.spec.style.StringSpec
import mock.MockInputReader
import view.InputView

class LottoRunnerTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        val inputView = InputView(MockInputReader(listOf("14000")))

        val lottoRunner = LottoRunner(inputView)
        lottoRunner.startLotto()
    }
})
