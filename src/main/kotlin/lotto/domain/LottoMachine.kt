package lotto.domain

import lotto.domain.Lotto.Companion.MAX_LOTTO_NUMBER
import lotto.domain.Lotto.Companion.MAX_LOTTO_NUMBER_SIZE
import lotto.domain.Lotto.Companion.MIN_LOTTO_NUMBER

/**
 * 로또를 정해진 수량만큼 생성하는 역할을 하는 클래스 입니다.
 */
class LottoMachine {

    private val range1to45 = (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER)

    fun issue(count: Int): IssuedLottos {
        return IssuedLottos(List(count) { createLotto() })
    }

    private fun createLotto(): Lotto {
        val randomSixNumbers = range1to45
            .shuffled()
            .take(MAX_LOTTO_NUMBER_SIZE)
            .sorted()
        return Lotto(randomSixNumbers.toSet())
    }
}
