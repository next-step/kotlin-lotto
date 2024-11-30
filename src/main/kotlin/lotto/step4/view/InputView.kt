package lotto.step4.view

import lotto.step4.domain.Lotto
import lotto.step4.domain.LottoNumber
import lotto.step4.domain.Money

object InputView {
    fun getPurchaseAmount(): Money {
        while (true) {
            println("구입금액을 입력해 주세요.")
            val money = readln().toLongOrNull()
            if (money != null) {
                return Money(money)
            } else {
                println("유효하지 않은 입력입니다. 숫자를 입력해 주세요.")
            }
        }
    }

    fun getManualPurchaseCount(): Long {
        while (true) {
            println("수동으로 구매할 로또 수를 입력해 주세요.")
            val input = readln().toLongOrNull() // 숫자로 변환, 실패 시 null 반환
            if (input != null && input >= 0) { // 0 이상의 숫자만 유효
                return input
            } else {
                println("유효하지 않은 입력입니다. 0 이상의 숫자를 입력해 주세요.")
            }
        }
    }

    fun getLastWeekWinningNumbers(): Set<LottoNumber> {
        while (true) {
            println("지난 주 당첨 번호를 입력해 주세요.")
            val input = readln()

            // 입력값을 파싱하여 유효성 검사를 수행
            val winningNumbers =
                input.split(",")
                    .mapNotNull { it.trim().toIntOrNull() } // 숫자가 아닌 값은 무시
                    .toSet()

            // 조건: 중복 없이 6개여야만 성공
            if (winningNumbers.size == 6) {
                return winningNumbers.map { LottoNumber(it) }.toSet()
            } else {
                println("유효하지 않은 입력입니다. 로또 당첨 번호는 중복되지 않고, 6개의 숫자를 쉼표(,)를 구분자로 입력해 주세요.")
            }
        }
    }

    fun getBonusNumber(): LottoNumber {
        while (true) {
            println("보너스 볼을 입력해 주세요.")
            val input = readln().toIntOrNull() // 숫자로 변환, 실패 시 null 반환
            if (input != null) {
                return LottoNumber(input) // 유효한 숫자일 경우 반환
            } else {
                println("유효하지 않은 입력입니다. 숫자를 입력해 주세요.")
            }
        }
    }

    fun getManualPurchaseNumbers(count: Long): List<Lotto> {
        println("수동으로 구매할 번호를 입력해 주세요.")
        return (1..count).map { readValidManualLotto() }
    }

    private fun readValidManualLotto(): Lotto {
        while (true) {
            val input = readLottoNumbers()
            if (isValidLottoNumbers(input)) {
                return Lotto.of(input.map { LottoNumber(it) })
            }
            println("유효하지 않은 입력입니다. 로또 번호는 중복되지 않고, 6개의 숫자를 입력해 주세요.")
        }
    }

    private fun readLottoNumbers(): Set<Int> {
        return readln()
            .split(",")
            .mapNotNull { it.trim().toIntOrNull() } // 숫자가 아닌 값 무시
            .toSet() // 중복 제거
    }

    private fun isValidLottoNumbers(numbers: Set<Int>): Boolean {
        return numbers.size == 6 // 중복 없이 6개 숫자
    }
}
