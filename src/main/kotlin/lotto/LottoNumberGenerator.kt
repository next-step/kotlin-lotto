package lotto

class LottoNumberGenerator {
    companion object {
        fun autoGenerate(): List<Int> {
            return (1..45).shuffled().slice(0..5)
        }
    }
}