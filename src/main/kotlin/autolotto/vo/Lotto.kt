package autolotto.vo

class Lotto(originNumbers: List<LottoNumber> = listOf()) {
    val numbers: List<LottoNumber> = originNumbers.takeIf { it.isNotEmpty() } ?: generateLottoNumbers()

    private fun generateLottoNumbers(): List<LottoNumber> {
        return (1..45).shuffled().take(6).sorted().map { LottoNumber.of(it) }
    }
}
