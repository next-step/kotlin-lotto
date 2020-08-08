package lotto

class Lottos(private val lottos: List<Lotto>) {
    fun match(winningLotto: WinningLotto): LottoResult {
        val result =
            lottos.map { winningLotto.match(it) }.groupingBy { it }.eachCount()
        return LottoResult(result)
    }
}
