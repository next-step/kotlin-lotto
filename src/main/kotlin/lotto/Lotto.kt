package lotto

private const val MAX_LOTTO_NUMBER = 45
private const val MIN_LOTTO_NUMBER = 1
private const val MAX_LOTTO_NUMBER_SIZE = 6

/**
 * 로또를 정해진 수량만큼 생성하는 역할을 하는 클래스 입니다.
 */
class LottoMachine {

    fun issue(count: Int): IssuedLottos {
        return IssuedLottos(List(count) { createLotto() })
    }

    private fun createLotto(): Lotto {
        val randomSixNumbers = List(MAX_LOTTO_NUMBER) { it + 1 }
            .shuffled()
            .take(MAX_LOTTO_NUMBER_SIZE)
            .sorted()
        return Lotto(randomSixNumbers.toSet())
    }
}

/**
 * 서로 중복되지 않는 1과 45사이의 숫자 6개를 가지는 로또 클래스 입니다.
 */
data class Lotto(
    val numbers: Set<Int>
) {
    init {
        require(numbers.size == MAX_LOTTO_NUMBER_SIZE) {
            "lotto number size must be 6"
        }
        require(numbers.all { it in (MIN_LOTTO_NUMBER..MAX_LOTTO_NUMBER) }) {
            "lotto number must be between 1 and 45"
        }
    }

    fun match(winningLotto: Lotto): Int {
        return numbers.intersect(winningLotto.numbers).size
    }
}
