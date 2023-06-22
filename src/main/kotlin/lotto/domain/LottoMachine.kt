package lotto.domain

import lotto.domain.Lotto.Companion.MAX_LOTTO_NUMBER_SIZE

/**
 * 로또를 정해진 수량만큼 생성하는 역할을 하는 클래스 입니다.
 */
class LottoMachine {

    fun issue(count: Int): List<Lotto> {
        return List(count) { createLotto() }
    }

    private fun createLotto(): Lotto {
        val randomSixNumbers = LottoNumber.LOTTO_NUMBERS
            .shuffled()
            .take(MAX_LOTTO_NUMBER_SIZE)
            .sorted()
        return Lotto(randomSixNumbers.toSet())
    }
}
