package lotto.domain

@JvmInline
value class Lottos private constructor(private val lottos: List<Lotto>) {

    operator fun plus(other: Lottos): Lottos = Lottos(lottos + other.lottos)

    fun toList(): List<Lotto> = lottos.toList()

    fun getSize(): Int = lottos.size

    fun toMatchingWinningNumbers(winningNumbers: LottoNumbers, bonusNumber: LottoNumber): List<MatchingWinningNumber> =
        lottos.map { MatchingWinningNumber.of(it, winningNumbers, bonusNumber) }

    companion object {
        fun generateAutoLottos(money: Wallet): Lottos {
            val values = MutableList(money.getLeftMoney() / Lotto.PRICE) { Lotto.generate() }
            return Lottos(values)
        }

        fun generateManualLottos(manualLottoNumbers: ManualLottoNumbers): Lottos {
            val values = manualLottoNumbers.generate()
            return Lottos(values)
        }

        fun from(lottos: List<Lotto>): Lottos = Lottos(lottos)
    }
}
