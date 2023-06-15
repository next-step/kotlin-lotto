package domain

import io.kotest.core.spec.style.StringSpec
import mock.MockInputReader

class LottoRunner(private val inputReader: MockInputReader) {
    fun startLotto() {
        print("구입금액을 입력해 주세요.")
        val money = inputReader.raedLine()
        print(money)
    }
}

class LottoRunnerTest : StringSpec({
    "클라이언트가 구입 금액을 정상적으로 입력한다." {
        val mockInputReader = MockInputReader(listOf("14000"))
        val lottoRunner = LottoRunner(mockInputReader)
        lottoRunner.startLotto()
    }
})
