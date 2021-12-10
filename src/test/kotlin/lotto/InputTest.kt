package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNum
import lotto.view.InputView
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class InputTest {
    private val inputView = InputView()
    private val winningNums = Lotto(
        listOf(1, 2, 3, 4, 5, 6)
            .map { LottoNum(it) }
            .toSet()
    )

    @Test
    fun `로또 구입금액에 빈 문자열 또는 null을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateMoney(null) }
        assertThrows<IllegalArgumentException> { InputView.validateMoney("") }
    }

    @Test
    fun `로또 구입금액에 숫자가 아닌 값을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateMoney("abc") }
    }

    @Test
    fun `입력한 로또 구입금액이 1000 미만인 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateMoney("100") }
    }

    @Test
    fun `입력한 로또 번호가 null 또는 빈 문자열인 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums(null) }
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums("") }
    }

    @Test
    fun `입력한 로또 번호에 쉼표나 숫자가 아닌 값이 포함되어 있는 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums("a,b,c,d,e,f") }
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums("!@#") }
    }

    @Test
    fun `입력한 로또 번호가 총 6개가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums("1,2,3,4") }
    }

    @Test
    fun `입력한 로또 번호에 중복된 숫자가 있는 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums("1,1,2,3,4,5") }
    }

    @Test
    fun `입력한 로또 번호가 1 ~ 45 사이의 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { inputView.parseToLottoNums("1,2,3,4,5,50") }
    }

    @Test
    fun `로또 번호를 바르게 입력한 경우`() {
        assertDoesNotThrow { inputView.parseToLottoNums("1,2,3,4,5,6") }
    }

    @Test
    fun `보너스 볼 번호에 null 또는 빈 문자열을 입력한 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateBonusNum(null, winningNums) }
        assertThrows<IllegalArgumentException> { InputView.validateBonusNum("", winningNums) }
    }

    @Test
    fun `보너스 볼 번호에 숫자가 아닌 다른 문자를 입력한 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateBonusNum("aaa", winningNums) }
    }

    @Test
    fun `보너스 볼 번호가 1 ~ 45 사이의 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateBonusNum("50", winningNums) }
    }

    @Test
    fun `보너스 볼 번호가 당첨 번호에 이미 존재하는 번호인 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateBonusNum("1", winningNums) }
    }

    @Test
    fun `수동으로 구입할 로또 개수의 입력값이 null 또는 빈 문자열인 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateManualCount(1, null) }
        assertThrows<IllegalArgumentException> { InputView.validateManualCount(1, "") }
    }

    @Test
    fun `수동으로 구입할 로또 개수의 입력값이 숫자가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateManualCount(1, "abc") }
    }

    @Test
    fun `수동으로 구입할 로또 개수가 구입 가능한 로또 개수보다 많은 경우`() {
        assertThrows<IllegalArgumentException> { InputView.validateManualCount(1, "3") }
    }
}
