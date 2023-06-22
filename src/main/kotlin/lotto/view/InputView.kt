package lotto.view

import lotto.domain.Lotto

class InputView {
    companion object {
        fun purchaseMoney(): Long {
            println("구입금액을 입력해 주세요.")
            return readln().toLong()
        }

        fun winningLotto(): Lotto {
            println("지난 주 당첨 번호를 입력해 주세요.")
            return Lotto(
                readln()
                    .split(",")
                    .map { it.toInt() }
                    .toList(),
            )
        }
    }
}
