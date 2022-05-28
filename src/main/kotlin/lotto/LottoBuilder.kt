package lotto

class LottoBuilder {
    fun create(number: Int = 1): List<Lotto> {
        return (1..number).map {
            val numbers = (LOTTO_MIN_NUMBER..LOTTO_MAX_NUMBER).shuffled()
                .subList(0, LOTTO_COUNT)
                .toSet()
            Lotto(numbers)
        }
    }
}
