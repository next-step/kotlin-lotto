package lotto.domain

object LottoGenerator {
    private const val MORE_THAN_LOTTO_PRICE_MESSAGE = "${Lotto.LOTTO_PRICE}이상의 금액을 입력해주세요"
    private val lottoNumbers = (Lotto.LOTTO_MIN_NUMBER..Lotto.LOTTO_MAX_NUMBER).toList()

    fun generateLottos(amount: Int): List<Lotto> {
        require(amount > Lotto.LOTTO_PRICE) { MORE_THAN_LOTTO_PRICE_MESSAGE }
        return Array(amount / Lotto.LOTTO_PRICE) { generateLotto() }.toList()
    }

    fun generateLotto(): Lotto {
        return Lotto(lottoNumbers.shuffled().take(Lotto.LOTTO_NUMBER_SIZE).sorted())
    }
}
