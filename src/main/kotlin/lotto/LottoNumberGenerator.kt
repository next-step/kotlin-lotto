package lotto

class LottoNumberGenerator {
    companion object{
        fun generateNumbers(): List<Int> {
            return (1..45).shuffled()
                .subList(0, 6)
        }
    }
}