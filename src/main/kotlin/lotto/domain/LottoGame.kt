package lotto.domain

data class LottoGame(val numbers: List<LottoNumber>) {

    companion object {
        private val numberPool = List(45) { v -> v + 1 }

        fun createWithAutoSelect() = LottoGame(makeRandomNumbers())

        private fun makeRandomNumbers() =
            numberPool
                .shuffled()
                .slice(0..5)
                .sorted()
                .map { LottoNumber(it) }
    }
}
