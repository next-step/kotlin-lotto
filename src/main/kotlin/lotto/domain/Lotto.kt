package lotto.domain

class Lottos(
    val list: List<Lotto>
) {

    companion object {
        fun getLottos(number: Int): Lottos {
            return List(number) { Lotto(LottoNumberGenerator.generate()) }.toLottos()
        }
    }
}

class Lotto(
    val numbers: List<Int>
) {

    init {
        require(numbers.size == 6) { "6개의 숫자가 필요합니다." }
        require(numbers.distinct().size == 6) { "중복되지 않은 6개의 숫자가 필요합니다." }
        require(numbers.all { it in 1..45 }) { "1~45의 수만 가능합니다" }
    }
}

fun List<Lotto>.toLottos() = Lottos(this)
