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
)


fun List<Lotto>.toLottos() = Lottos(this)
