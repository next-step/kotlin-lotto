package lotto.view

import lotto.domain.Lotto
import lotto.domain.Money
import lotto.domain.PurchaseRequest

class ManualIssueView(private val io: IO) {

    fun getPurchaseRequest(money: Money): PurchaseRequest {
        io.print("\n수동으로 구매할 로또 수를 입력해 주세요.")

        val manualCount = readCount()

        if (manualCount == 0) {
            return PurchaseRequest(money = money, manualLottos = emptyList())
        }

        io.print("\n수동으로 구매할 번호를 입력해 주세요.")

        return PurchaseRequest(money = money, manualLottos = List(manualCount) { readManualLotto() })
    }

    private tailrec fun readCount(): Int {
        val result = io.read().toIntOrNull() ?: -1

        if (result < 0) {
            io.print("유효한 0 이상의 숫자를 입력해주세요.")
            return readCount()
        }

        return result
    }

    private tailrec fun readManualLotto(): Lotto {
        val result = io.read()
            .replace(" ", "")
            .split(',')
            .mapNotNull { it.toIntOrNull() }

        if (result.size != Lotto.NUMBER_COUNT) {
            io.print("유효한 로또번호를 입력해주세요.")
            return readManualLotto()
        }

        return Lotto.manualOf(result)
    }
}
