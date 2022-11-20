package simulator.lotto

class Lotto(numbers: Set<Int>) {
    val numbers : Set<Int>

    init {
        require(numbers.size == LOTTO_NUMBERS_COUNT){
            "로또 번호는 6개의 숫자로 구성되어야 합니다"
        }

        require(numbers.maxOf { it } <= MAX_NUMBER){
            "로또 번호는 45 이하이어야 합니다"
        }

        require(numbers.minOf { it } >= MIN_NUMBER){
            "로또 번호는 1 이상이어야 합니다"
        }

        this.numbers = numbers.toSortedSet()
    }

    companion object {
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val LOTTO_NUMBERS_COUNT = 6
        private val lottoNumbers = MIN_NUMBER..MAX_NUMBER

        fun generate(): Lotto {
            val lottoNumbers = lottoNumbers.shuffled()
                .slice(1..LOTTO_NUMBERS_COUNT)
                .toSet()

            return Lotto(lottoNumbers)
        }
    }
}
