package lotto.view

import Lottos
import lotto.domain.Lotto
import lotto.domain.LottoNumber

class InputView {
    fun readPurchaseAmount(): Int {
        println("구입금액을 입력해 주세요. 한장당 가격은 1000원입니다. ")
        return readln().toInt()
    }

    fun readWinningNumbers(): Lotto {
        println("지난 주 당첨 번호를 입력해 주세요. 6자리이며 쉼표 기준으로 구분합니다.")
        return try {
            val numbers =
                readln().split(",")
                    .map { it.trim().toInt() }
                    .map { LottoNumber(it) } // Int를 LottoNumber로 변환
            Lotto(numbers)
        } catch (e: Exception) {
            throw IllegalArgumentException("올바른 당첨 번호를 입력해주세요.")
        }
    }

    fun readBonusBall(winningNumbers: Lotto): LottoNumber {
        println("보너스 볼을 입력해 주세요.")
        val bonusBall = readln().trim().toInt()
        val bonusBallNumber = LottoNumber(bonusBall)
        require(!winningNumbers.numbers.contains(bonusBallNumber)) { "보너스 볼은 당첨 번호와 중복될 수 없습니다." }
        return bonusBallNumber
    }

    fun readManualLottoCount(): Int {
        println("\n수동으로 구매할 로또 수를 입력해 주세요.")
        return readln().toInt()
    }

    fun readManualLottoNumbers(count: Int): Lottos {
        println("\n수동으로 구매할 번호를 입력해 주세요.")

        val manualLottos =
            (1..count).map {
                val numbers =
                    readln().split(",")
                        .map { it.trim().toInt() }
                        .map { LottoNumber(it) }
                Lotto(numbers)
            }
        return Lottos.from(manualLottos)
    }
}
