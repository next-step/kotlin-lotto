package lotto.domain

class Lotto(originNumbers: List<LottoNumber> = listOf()) : List<LottoNumber> by originNumbers {
    val numbers: List<LottoNumber> = originNumbers.takeIf { it.isNotEmpty() } ?: LottoNumber.generateLottoNumbers()
}
