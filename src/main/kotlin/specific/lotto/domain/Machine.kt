package specific.lotto.domain

sealed class Machine {

    abstract fun generateNumberCombination(): LottoNumber

    class RandomNumberMachine: Machine() {
        override fun generateNumberCombination() = LottoNumber((1..45).shuffled().take(6).sorted())
    }

    class SpecificNumberMachine(val lottoNumberValues: List<Int> = listOf(1, 2, 3, 4, 5, 6)): Machine() {
        override fun generateNumberCombination() = LottoNumber(lottoNumberValues)
    }

}
