package lotto.model

class LottoMachine {

    fun createLottos(count: Int): List<Lotto> {
        return List(count) {
            createLotto()
        }
    }

    private fun createLotto() = Lotto(
        lottoNumbers = createDistinctSixNumbers()
            .map { LottoNumber.from(it) }
            .toList()
    )

    private fun createDistinctSixNumbers(): List<Int> {
        return buildSet(LOTTO_SIZE) {
            putUntilSixLottoNumbers()
        }.shuffled().toList()
    }
    private fun MutableSet<Int>.putUntilSixLottoNumbers() {
        while (this.size != LOTTO_SIZE) {
            this.add((MINIMUM_NUMBER..MAXIMUM_NUMBER).random())
        }
    }
    companion object {
        private const val LOTTO_SIZE = 6
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
    }
}
