package lotto.domain

class Lottos(
    val list: List<Lotto>
) {

    fun manualCount() = list.filter { it.lottoType == LottoType.MANUAL }.size
    fun autoCount() = list.filter { it.lottoType == LottoType.AUTO }.size

    companion object {
        fun getAutoLottos(number: Int): Lottos {
            return List(number) { Lotto(LottoNumberGenerator.generate(), LottoType.AUTO) }.toLottos()
        }

        fun getManualLottos(numbers: List<List<Int>>): Lottos {
            return numbers.map { Lotto(it, LottoType.MANUAL) }.toLottos()
        }
    }
}

class Lotto(
    val numbers: List<Int>,
    val lottoType: LottoType = LottoType.AUTO
) {

    init {
        require(numbers.size == 6) { "6개의 숫자가 필요합니다." }
        require(numbers.distinct().size == 6) { "중복되지 않은 6개의 숫자가 필요합니다." }
        require(numbers.all { it in 1..45 }) { "1~45의 수만 가능합니다" }
    }
}

fun List<Lotto>.toLottos() = Lottos(this)
